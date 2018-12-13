package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class CityTest {

    @Test
    public void testCityWeek2() {

        try {
            City db = new City("c:/work/ipdb/mydata4vipweek2.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());

            System.out.println(Arrays.toString(db.find("118.28.1.1", "CN")));
        } catch (IOException | IPFormatException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testCityDay1() {
        try {
            City db = new City("c:/work/ipdb/mydata4vipday1.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());

            System.out.println(Arrays.toString(db.find("118.28.1.1", "CN")));
        } catch (IOException | IPFormatException ex) {
            ex.printStackTrace();
        }
    }
}
