package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;

public class RiskTest {
    @Test
    public void testRisk() {
        try {
            Risk db = new Risk("c:/work/ipdb/v6risk.ipdb");

            System.out.println(db.fields());

            System.out.println(db.findInfo("2001:240:2a3b:7100::"));

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
