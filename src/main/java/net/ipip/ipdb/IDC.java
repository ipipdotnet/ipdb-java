package net.ipip.ipdb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IDC {

    /**
     * @var Reader
     */
    private Reader reader;

    public IDC(String name) throws IOException,InvalidDatabaseException {
        this.reader = new Reader(name);
    }

    public IDC(InputStream in) throws IOException, InvalidDatabaseException {
        this.reader = new Reader(in);
    }

    public boolean reload(String name) {
        try {
            Reader r = new Reader(name);
            this.reader = r;
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public String[] find(String addr, String language) throws IPFormatException, InvalidDatabaseException {
        return this.reader.find(addr, language);
    }

    public Map<String, String> findMap(String addr, String language) throws IPFormatException, InvalidDatabaseException {
        String[] data = this.reader.find(addr, language);
        if (data == null) {
            return null;
        }

        Map<String, String> m = new HashMap<String, String>();

        String[] fields = this.reader.getSupportFields();

        for (int i = 0, l = data.length; i < l; i++) {
            m.put(fields[i], data[i]);
        }

        return m;
    }

    public IDCInfo findInfo(String addr, String language) throws IPFormatException, InvalidDatabaseException {

        String[] data = this.reader.find(addr, language);
        if (data == null) {
            return null;
        }
        return new IDCInfo(data);
    }

    public boolean isIPv4() {
        return this.reader.isIPv4();
    }

    public boolean isIPv6() {
        return this.reader.isIPv6();
    }

    public String fields() {
        return Arrays.toString(this.reader.getSupportFields());
    }

    public int buildTime() {
        return this.reader.getBuildUTCTime();
    }

    public String languages() {
        return this.reader.getSupportLanguages();
    }
}