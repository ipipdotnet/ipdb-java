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
        sb.append("owner_domain:");
        sb.append(this.getOwnerDomain());
        sb.append("\n");
        sb.append("isp_domain:");
        sb.append(this.getIspDomain());
        sb.append("\n");
        sb.append("latitude:");
        sb.append(this.getLatitude());
        sb.append("\n");
        sb.append("longitude:");
        sb.append(this.getLongitude());
        sb.append("\n");

        sb.append("timezone:");
        sb.append(this.getTimezone());
        sb.append("\n");

        sb.append("utc_offset:");
        sb.append(this.getUtcOffset());
        sb.append("\n");

        sb.append("china_admin_code:");
        sb.append(this.getChinaAdminCode());
        sb.append("\n");

        sb.append("idd_code:");
        sb.append(this.getIddCode());
        sb.append("\n");

        sb.append("country_code:");
        sb.append(this.getCountryCode());
        sb.append("\n");

        sb.append("continent_code:");
        sb.append(this.getContinentCode());
        sb.append("\n");

        sb.append("idc:");
        sb.append(this.getIDC());
        sb.append("\n");

        sb.append("base_station:");
        sb.append(this.getBaseStation());
        sb.append("\n");

        sb.append("country_code3:");
        sb.append(this.getCountryCode3());
        sb.append("\n");

        sb.append("european_union:");
        sb.append(this.getEuropeanUnion());
        sb.append("\n");

        sb.append("currency_code:");
        sb.append(this.getCurrencyCode());
        sb.append("\n");

        sb.append("currency_name:");
        sb.append(this.getCurrencyName());
        sb.append("\n");

        sb.append("anycast:");
        sb.append(this.getAnycast());

        return sb.toString();

    }
}
