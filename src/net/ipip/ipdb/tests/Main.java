package net.ipip.ipdb.tests;

import net.ipip.ipdb.Reader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Reader db = new Reader("C:/WORK/tiantexin/bb/17mon.ipdb");

            System.out.println(db.getBuildUTCTime());
            System.out.println(Arrays.toString(db.getSupportFields()));

            System.out.println(Arrays.toString(db.find("0.0.0.1", "CN")));
            System.out.println(Arrays.toString(db.find("1.1.1.1", "CN")));
            System.out.println(Arrays.toString(db.find("255.255.255.255", "CN")));
          //  System.out.println(Arrays.toString(db.find("2001:250:200::", "CN")));

            Long now = System.nanoTime();

            for (int i = 0; i < 1000000; i++) {
                db.find("8.8.8.8", "CN");
            }

            System.out.println((System.nanoTime() - now) / 1000/ 1000);

        } catch (Exception e) {
          //  e.printStackTrace();
        }
    }
}
