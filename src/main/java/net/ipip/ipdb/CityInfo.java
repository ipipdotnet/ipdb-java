package net.ipip.ipdb;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class CityInfo {

    private String[] data;
    private Map<String,String> M;

    private int size;

    public CityInfo(String[] data) {
        this.data = data;
        this.size = data.length;
    }

    public CityInfo(Map<String,String> kv) {
        this.M = kv;
    }

    private String get(int index) {
        return this.size >= index ? this.data[index-1] : "";
    }

    public String getCountryName() {
        if (this.M.size() > 0) {
            return this.M.get("country_name");
        } else if (this.data.length > 0) {
            return this.get(1);
        }
        return null;
    }

    public String getRegionName() {
        if (this.M.size() > 0) {
            return this.M.get("region_name");
        } else if (this.data.length > 1) {
            return this.get(2);
        } else {
            return null;
        }
    }

    public String getCityName() {
        if (this.M.size() > 0) {
            return this.M.get("city_name");
        } else if (this.data.length > 2) {
            return this.get(3);
        } else {
            return null;
        }
    }

    public String getDistrictName() {
        if (this.M.size() > 0) {
            return this.M.get("district_name");
        } else {
            return null;
        }
    }
    
    public String getOwnerDomain() {
        if (this.M.size() > 0) {
            return this.M.get("owner_domain");
        } else if (this.data.length > 3) {
            return this.get(4);
        } else {
            return null;
        }
    }

    public String getIspDomain() {
        if (this.M.size() > 0) {
            return this.M.get("isp_domain");
        } else if (this.data.length > 4) {
            return this.get(5);
        } else {
            return null;
        }
    }

    public String getLatitude() {
        if (this.M.size() > 0) {
            return this.M.get("latitude");
        } else if (this.data.length > 5) {
            return this.get(6);
        } else {
            return null;
        }
    }

    public String getLongitude() {
        if (this.M.size() > 0) {
            return this.M.get("longitude");
        } else if (this.data.length > 6) {
            return this.get(7);
        } else {
            return null;
        }
    }

    public String getTimezone() {
        if (this.M.size() > 0) {
            return this.M.get("timezone");
        } else if (this.data.length > 7) {
            return this.get(8);
        } else {
            return null;
        }
    }

    public String getUtcOffset() {
        if (this.M.size() > 0) {
            return this.M.get("utc_offset");
        } else if (this.data.length > 8) {
            return this.get(9);
        } else {
            return null;
        }
    }

    public String getChinaAdminCode() {
        if (this.M.size() > 0) {
            return this.M.get("china_admin_code");
        } else if (this.data.length > 9) {
            return this.get(10);
        } else {
            return null;
        }
    }

    public String getIddCode() {
        if (this.M.size() > 0) {
            return this.M.get("idd_code");
        } else if (this.data.length > 10) {
            return this.get(11);
        } else {
            return null;
        }
    }

    public String getCountryCode() {
        if (this.M.size() > 0) {
            return this.M.get("country_code");
        } else if (this.data.length > 11) {
            return this.get(12);
        } else {
            return null;
        }
    }

    public String getContinentCode() {
        if (this.M.size() > 0) {
            return this.M.get("continent_code");
        } else if (this.data.length > 12) {
            return this.get(13);
        } else {
            return null;
        }
    }

    public String getLine() {
        if (this.M.size() > 0) {
            return this.M.get("line");
        } else {
            return null;
        }
    }
    
    public String getIDC() {
        if (this.M.size() > 0) {
            return this.M.get("idc");
        } else if (this.data.length > 13) {
            return this.get(14);
        } else {
            return null;
        }
    }

    public String getBaseStation() {
        if (this.M.size() > 0) {
            return this.M.get("base_station");
        } else if (this.data.length > 14) {
            return this.get(15);
        } else {
            return null;
        }
    }

    public String getCountryCode3() {
        if (this.M.size() > 0) {
            return this.M.get("country_code3");
        } else if (this.data.length > 15) {
            return this.get(16);
        } else {
            return null;
        }
    }

    public String getEuropeanUnion() {
        if (this.M.size() > 0) {
            return this.M.get("european_union");
        } else if (this.data.length > 16) {
            return this.get(17);
        } else {
            return null;
        }
    }

    public String getCurrencyCode() {
        if (this.M.size() > 0) {
            return this.M.get("currency_code");
        } else if (this.data.length > 17) {
            return this.get(18);
        } else {
            return null;
        }
    }

    public String getCurrencyName() {
        if (this.M.size() > 0) {
            return this.M.get("currency_name");
        } else if (this.data.length > 18) {
            return this.get(19);
        } else {
            return null;
        }
    }

    public String getAnycast() {
        if (this.M.size() > 0) {
            return this.M.get("anycast");
        } else if (this.data.length > 19) {
            return this.get(20);
        } else {
            return null;
        }
    }

    public String getRoute() {
        if (this.M.size() > 0) {
            return this.M.get("route");
        } else {
            return null;
        }
    }

    public String getUsageType() {
        if (this.M.size() > 0) {
            return this.M.get("usage_type");
        } else {
            return null;
        }
    }

    public DistrictInfo getDistrictInfo() {
        if (this.M.size() > 0) {
            String str = this.M.get("district_info");
            if (str == null) {
                return null;
            }
            Map<String,String> info = JSONObject.parseObject(str, Map.class);

            String[] data = new String[8];
            data[0] = this.getCountryName();
            data[1] = this.getRegionName();
            data[2] = this.getCityName();
            data[3] = info.get("district_name");
            data[4] = info.get("china_admin_code");
            data[5] = info.get("covering_radius");
            data[6] = info.get("longitude");
            data[7] = info.get("latitude");

            return new DistrictInfo(data);
        }
        return null;
    }

    public AsnInfo[] getAsnInfos() {

        if (this.M.size() > 0) {
            String str = this.M.get("asn_info");
            if (str == null) {
                return null;
            }

            return JSONObject.parseObject(str, AsnInfo[].class);
        }

        return null;
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
