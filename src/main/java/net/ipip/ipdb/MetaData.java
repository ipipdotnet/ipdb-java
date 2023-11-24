package net.ipip.ipdb;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * @copyright IPIP.net
 */
public class MetaData {
    public int Build;
    @JSONField(name = "ip_version")
    public int IPVersion;
    @JSONField(name = "node_count")
    public int nodeCount;
    public Map<String, Integer> Languages;
    public String[] Fields;
    @JSONField(name = "total_size")
    public int totalSize;
}