# ipdb-java
用于解析 IPIP.net 提供的IPDB格式离线数据库

# IPv4中国地级市精度试用版
[IPDB Database](https://www.ipip.net/product/client.html)

# 代码示例
## 地级市精度库
<pre>
        try {
            // City类可用于IPDB格式的IPv4/IPv6定制版本
            City db = new City("/path/to/ipiptest.ipdb");
            
            // db.find(address, language) 返回索引数组
            System.out.println(Arrays.toString(db.find("1.1.1.1", "CN")));

            // db.findInfo(address, language) 返回 CityInfo 对象
            CityInfo info = db.findInfo("118.28.1.1", "CN");
            System.out.println(info);

        } catch (Exception e) {
            e.printStackTrace();
        }
</pre>

### IPDB格式可支持的字段说明
<pre>
country_name : 国家名字 
region_name  : 省名字   
city_name    : 城市名字 
owner_domain : 所有者域名  
isp_domain  : 运营商域名   
latitude  :  纬度 
longitude : 经度    
timezone : 时区  
utc_offset : UTC时区    
china_admin_code : 中国行政区划代码
idd_code : 国家电话号码前缀
country_code : 国家2位代码 
continent_code : 大洲代码  
line : 线路，国内特色
idc : IDC |  VPN  
base_station : 基站 | WIFI
country_code3 : 国家3位代码 
european_union : 是否为欧盟成员国： 1 | 0 
currency_code : 当前国家货币代码   
currency_name : 当前国家货币名称   
anycast : ANYCAST      
usage_type: 应用类型/应用场景
district_name: 区县名称（仅中国,购买了区县级别） 
asn: ASNumber
route: route prefix
</pre>
