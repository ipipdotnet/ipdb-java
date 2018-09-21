package net.ipip.ipdb.tests;

import net.ipip.ipdb.Reader;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            Reader db = new Reader("C:/study/datalib/mydata6vipday2.ipdb");

            System.out.println(db.getBuildUTCTime());
            System.out.println(Arrays.toString(db.getSupportFields()));
            System.out.println(db.getMeta().IPVersion);

            System.out.println(Arrays.toString(db.find("2001:250:200::", "CN")));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
