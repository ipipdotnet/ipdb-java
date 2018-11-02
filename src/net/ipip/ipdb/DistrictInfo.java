package net.ipip.ipdb;

public class DistrictInfo {

    private String[] data;

    public DistrictInfo(String[] data) {
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

    public String getDistrictName() {
        return this.data[3];
    }

    public String getChinaAdminCode() {
        return this.data[4];
    }

    public String getCoveringRadius() {
        return this.data[5];
    }

    public String getLatitude() {
        return this.data[6];
    }

    public String getLongitude() {
        return this.data[7];
    }
}
