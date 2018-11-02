package net.ipip.ipdb;

public class IDCInfo {

    private String[] data;

    public IDCInfo(String[] data) {
        this.data = data;
    }

    public String getCountryName() {
        return this.data[0];
    }

    public String getRegionName() {
        return this.data[1];
    }

    public String getCityName() {
        return this.data[2];
    }

    public String getOwnerDomain() {
        return this.data[3];
    }

    public String getIspDomain() {
        return this.data[4];
    }

    public String getIDC() {
        return this.data[5];
    }
}
