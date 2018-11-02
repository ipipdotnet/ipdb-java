package net.ipip.ipdb;

public class CityInfo {

    private String[] data;

    public CityInfo(String[] data) {
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

    public String getLatitude() {
        return this.data[5];
    }

    public String getLongitude() {
        return this.data[6];
    }

    public String getTimezone() {
        return this.data[7];
    }

    public String getUtcOffset() {
        return this.data[8];
    }

    public String getChinaAdminCode() {
        return this.data[9];
    }

    public String getIddCode() {
        return this.data[10];
    }

    public String getCountryCode() {
        return this.data[11];
    }

    public String getContinentCode() {
        return this.data[12];
    }

    public String getIDC() {
        return this.data[13];
    }

    public String getBaseStation() {
        return this.data[14];
    }

    public String getCountryCode3() {
        return this.data[15];
    }

    public String getEuropeanUnion() {
        return this.data[16];
    }

    public String getCurrencyCode() {
        return this.data[17];
    }

    public String getCurrencyName() {
        return this.data[18];
    }

    public String getAnycast() {
        return this.data[19];
    }
}
