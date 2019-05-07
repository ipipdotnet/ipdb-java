package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;

public class DistrictTest {

    @Test
    public void testDistrict() {

        try {
            District db = new District("c:/tiantexin/download/china_district.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());
            DistrictInfo info = db.findInfo("123.121.1.69", "CN");
            System.out.println(info.getLatitude());
            System.out.println(info.getLongitude());
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }
}
