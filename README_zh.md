# ipdb-java
用于解析 IPIP.net 提供的IPDB格式离线数据库

# 免费的中国地级市精度库下载
[IPDB Database](https://www.ipip.net/product/client.html)

# 代码示例
## 地级市精度库
<pre>
        try {
            // City类可用于IPDB格式的IPv4免费库，IPv4与IPv6的每周高级版、每日标准版、每日高级版、每日专业版、每日旗舰版
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

## 中国地区区县级数据库
<pre>
       try {
            District db = new District("/path/to/china_district.ipdb");

            System.out.println(Arrays.toString(db.find("1.12.13.1", "CN")));

            DistrictInfo info = db.findInfo("1.12.13.1", "CN");
            if (info != null) {
                System.out.println(info);
                System.out.println(info.getCountryName());
            }

            Map<String, String> m = db.findMap("1.12.13.1", "CN");

            System.out.println(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
</pre>

## 基站IP库
<pre>
        try {
            BaseStation db = new BaseStation("/path/to/base_station.ipdb");
            System.out.println(Arrays.toString(db.find("1.68.1.255", "CN")));
            System.out.println(db.findInfo("1.68.1.255", "CN"));
        } catch (Exception e) {
            e.printStackTrace();
        }
</pre>

## IDC IP库
<pre>
        try {
            IDC db = new IDC("/path/to/idc_list.ipdb");

            System.out.println(Arrays.toString(db.find("1.1.1.1", "CN")));

            IDCInfo info = db.findInfo("8.8.8.8", "CN");

            System.out.println(info.getCountryName());

            Map<String, String> m = db.findMap("114.114.114.114", "CN");

            System.out.println(m);

        } catch (Exception e) {
            e.printStackTrace();
        }
</pre>