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

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("country_name:");
        sb.append(this.getCountryName());
        sb.append("\n");
        sb.append("region_name:");
        sb.append(this.getRegionName());
        sb.append("\n");
        sb.append("city_name:");
        sb.append(this.getCityName());
        sb.append("\n");
        sb.append("district_name:");
        sb.append(this.getDistrictName());
        sb.append("\n");
        sb.append("china_admin_code:");
        sb.append(this.getChinaAdminCode());
        sb.append("\n");
        sb.append("covering_radius:");
        sb.append(this.getCoveringRadius());
        sb.append("\n");
        sb.append("latitude:");
        sb.append(this.getLatitude());
        sb.append("\n");
        sb.append("longitude:");
        sb.append(this.getLongitude());

        return sb.toString();
    }
}
