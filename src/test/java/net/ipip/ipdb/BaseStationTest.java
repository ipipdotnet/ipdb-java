package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;

public class BaseStationTest {
    @Test
    public void testBaseStation() {
        try {
            BaseStation db = new BaseStation("c:/work/ipdb/base_station.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
