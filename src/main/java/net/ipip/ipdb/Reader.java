package net.ipip.ipdb;

import com.alibaba.fastjson.JSONObject;
import sun.net.util.IPAddressUtil;

import java.io.*;
import java.util.Arrays;


public class Reader {

    private int fileSize;
    private int nodeCount;

    private MetaData meta;
    private byte[] data;

    private int v4offset;

    public Reader(String name) throws IOException, InvalidDatabaseException {
        this(new FileInputStream(new File(name)));
    }

    public Reader(InputStream in) throws IOException, InvalidDatabaseException {
        this.init(this.readAllAsStream(in));
    }

    protected byte[] readAllAsStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        in.close();
        return out.toByteArray();
    }

    protected void init(byte[] data) throws InvalidDatabaseException {

        this.data = data;
        this.fileSize = data.length;

        long metaLength = bytesToLong(
                this.data[0],
                this.data[1],
                this.data[2],
                this.data[3]
        );

        byte[] metaBytes = Arrays.copyOfRange(this.data, 4, Long.valueOf(metaLength).intValue() + 4);

        MetaData meta = JSONObject.parseObject(new String(metaBytes), MetaData.class);
        this.nodeCount = meta.nodeCount;
        this.meta = meta;

        if ((meta.totalSize + Long.valueOf(metaLength).intValue() + 4) != this.data.length) {
            throw new InvalidDatabaseException("database file size error");
        }

        this.data = Arrays.copyOfRange(this.data, Long.valueOf(metaLength).intValue() + 4, this.fileSize);

        /** for ipv4 */
        if (0x01 == (this.meta.IPVersion & 0x01))
        {
            int node = 0;
            for (int i = 0; i < 96 && node < this.nodeCount; i++) {
                if (i >= 80) {
                    node = this.readNode(node, 1);
                } else {
                    node = this.readNode(node, 0);
                }
            }

            this.v4offset = node;
        }
    }

    public String[] find(String addr, String language) throws IPFormatException, InvalidDatabaseException {

        int off;
        try {
            off = this.meta.Languages.get(language);
        } catch (NullPointerException e) {
            return null;
        }

        byte[] ipv;

        if (addr.indexOf(":") > 0) {
            ipv = IPAddressUtil.textToNumericFormatV6(addr);
            if (ipv == null) {
                throw new IPFormatException("ipv6 format error");
            }
            if ((this.meta.IPVersion & 0x02) != 0x02){
                throw new IPFormatException("no support ipv6");
            }

        } else if (addr.indexOf(".") > 0) {
            ipv = IPAddressUtil.textToNumericFormatV4(addr);
            if (ipv == null) {
                throw new IPFormatException("ipv4 format error");
            }
            if ((this.meta.IPVersion & 0x01) != 0x01){
                throw new IPFormatException("no support ipv4");
            }
        } else {
            throw new IPFormatException("ip format error");
        }

        int node = 0;
        try {
            node = this.findNode(ipv);
        } catch (NotFoundException nfe) {
            return null;
        }

        final String data = this.resolve(node);

        return Arrays.copyOfRange(data.split("\t", this.meta.Fields.length * this.meta.Languages.size()), off, off+this.meta.Fields.length);
    }
    
    private int findNode(byte[] binary) throws NotFoundException {

        int node = 0;

        final int bit = binary.length * 8;

        if (bit == 32) {
            node = this.v4offset;
        }

        for (int i = 0; i < bit; i++) {
            if (node > this.nodeCount) {
                break;
            }

            node = this.readNode(node, 1 & ((0xFF & binary[i / 8]) >> 7 - (i % 8)));
        }

        if (node > this.nodeCount) {
            return node;
        }

        throw new NotFoundException("ip not found");
    }

    private String resolve(int node) throws InvalidDatabaseException {
        final int resoloved = node - this.nodeCount + this.nodeCount * 8;
        if (resoloved >= this.fileSize) {
            throw new InvalidDatabaseException("database resolve error");
        }

        byte b = 0;
        int size = Long.valueOf(bytesToLong(
                b,
                b,
                this.data[resoloved],
                this.data[resoloved+1]
        )).intValue();

        if (this.data.length < (resoloved + 2 + size)) {
            throw new InvalidDatabaseException("database resolve error");
        }

        try {
            return new String(this.data, resoloved + 2, size, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new InvalidDatabaseException("database resolve error");
        }
    }

    private int readNode(int node, int index) {
        int off = node * 8 + index * 4;

        return Long.valueOf(bytesToLong(
                this.data[off],
                this.data[off+1],
                this.data[off+2],
                this.data[off+3]
        )).intValue();
    }

    private static long bytesToLong(byte a, byte b, byte c, byte d) {
        return int2long((((a & 0xff) << 24) | ((b & 0xff) << 16) | ((c & 0xff) << 8) | (d & 0xff)));
    }

    private static long int2long(int i) {
        long l = i & 0x7fffffffL;
        if (i < 0) {
            l |= 0x080000000L;
        }
        return l;
    }

    public boolean isIPv4() {
        return (this.meta.IPVersion & 0x01) == 0x01;
    }

    public boolean isIPv6() {
        return (this.meta.IPVersion & 0x02) == 0x02;
    }

    public int getBuildUTCTime() {
        return this.meta.Build;
    }

    public String[] getSupportFields() {
        return this.meta.Fields;
    }

    public String getSupportLanguages() {
        return this.meta.Languages.keySet().toString();
    }
}