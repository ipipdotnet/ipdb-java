package net.ipip.ipdb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class District {

    /**
     * @var Reader
     */
    private Reader reader;

    public District(String name) throws IOException,InvalidDatabaseException {
        this.reader = new Reader(name);
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

    public DistrictInfo findInfo(String addr, String language) throws IPFormatException, InvalidDatabaseException {

        String[] data = this.reader.find(addr, language);
        if (data == null) {
            return null;
        }

        return new DistrictInfo(data);
    }

    public boolean isIPv4() {
        return (this.reader.getMeta().IPVersion & 0x01) == 0x01;
    }

    public boolean isIPv6() {
        return (this.reader.getMeta().IPVersion & 0x02) == 0x02;
    }

    public String[] fields() {
        return this.reader.getSupportFields();
    }

    public int buildTime() {
        return this.reader.getBuildUTCTime();
    }
}