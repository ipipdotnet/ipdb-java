package net.ipip.ipdb;

import java.util.Map;

public class RiskInfo {

    private Map<String,String> data;

    public RiskInfo(Map<String,String> map) {
        this.data = map;
    }

    public int getScore() {
        String s = this.data.get("score");
        if (s == null) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    public String getBehavior() {
        String s = this.data.get("behavior");
        if (s == null) {
            return "";
        } else {
            return s;
        }
    }

    public String getCountryCode() {
        String s = this.data.get("country_code");
        if (s == null) {
            return "";
        } else {
            return s;
        }
    }
}
