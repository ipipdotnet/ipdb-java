package net.ipip.ipdb;

import com.alibaba.fastjson.annotation.JSONField;

public class AsnInfo {

    public int ASN;

    @JSONField(name = "reg")
    public String Registry;

    @JSONField(name = "cc")
    public String Country;

    @JSONField(name = "net")
    public String NetName;

    @JSONField(name = "org")
    public String OrgName;
}
