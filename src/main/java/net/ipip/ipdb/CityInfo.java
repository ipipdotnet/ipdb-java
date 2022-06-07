package net.ipip.ipdb;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class CityInfo {

    private Map<String,String> M;

    public CityInfo(Map<String,String> kv) {
        this.M = kv;
    }

    public String getCountryName() {
        if (this.M.size() > 0) {
            return this.M.get("country_name");
        }
        return null;
    }

    public String getRegionName() {
        if (this.M.size() > 0) {
            return this.M.get("region_name");
        } else {
            return null;
        }
    }

    public String getCityName() {
        if (this.M.size() > 0) {
            return this.M.get("city_name");
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
        } else {
            return null;
        }
    }

    public String getIspDomain() {
        if (this.M.size() > 0) {
            return this.M.get("isp_domain");
        } else {
            return null;
        }
    }

    public String getLatitude() {
        if (this.M.size() > 0) {
            return this.M.get("latitude");
        } else {
            return null;
        }
    }

    public String getLongitude() {
        if (this.M.size() > 0) {
            return this.M.get("longitude");
        } else {
            return null;
        }
    }

    public String getTimezone() {
        if (this.M.size() > 0) {
            return this.M.get("timezone");
        } else {
            return null;
        }
    }

    public String getUtcOffset() {
        if (this.M.size() > 0) {
            return this.M.get("utc_offset");
        } else {
            return null;
        }
    }

    public String getChinaRegionCode() {
        if (this.M.size() > 0) {
            return this.M.get("china_region_code");
        } else {
            return null;
        }
    }

    public String getChinaCityCode() {
        if (this.M.size() > 0) {
            return this.M.get("china_city_code");
        } else {
            return null;
        }
    }

    public String getChinaAdminCode() {
        if (this.M.size() > 0) {
            return this.M.get("china_admin_code");
        } else {
            return null;
        }
    }

    public String getIddCode() {
        if (this.M.size() > 0) {
            return this.M.get("idd_code");
        } else {
            return null;
        }
    }

    public String getCountryCode() {
        if (this.M.size() > 0) {
            return this.M.get("country_code");
        } else {
            return null;
        }
    }

    public String getContinentCode() {
        if (this.M.size() > 0) {
            return this.M.get("continent_code");
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
        } else {
            return null;
        }
    }

    public String getBaseStation() {
        if (this.M.size() > 0) {
            return this.M.get("base_station");
        } else {
            return null;
        }
    }

    public String getCountryCode3() {
        if (this.M.size() > 0) {
            return this.M.get("country_code3");
        } else {
            return null;
        }
    }

    public String getEuropeanUnion() {
        if (this.M.size() > 0) {
            return this.M.get("european_union");
        } else {
            return null;
        }
    }

    public String getCurrencyCode() {
        if (this.M.size() > 0) {
            return this.M.get("currency_code");
        } else {
            return null;
        }
    }

    public String getCurrencyName() {
        if (this.M.size() > 0) {
            return this.M.get("currency_name");
        } else {
            return null;
        }
    }

    public String getAnycast() {
        if (this.M.size() > 0) {
            return this.M.get("anycast");
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
            if (!str.startsWith("[")) {
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

        sb.append("china_region_code:");
        sb.append(this.getChinaRegionCode());
        sb.append("\n");

        sb.append("china_city_code:");
        sb.append(this.getChinaCityCode());
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
