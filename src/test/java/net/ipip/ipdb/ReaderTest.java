package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;

public class ReaderTest {

    @Test
    public void testReader() {
        try {
            IDC db = new IDC("c:/work/ipdb/idc_list.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());
//            Thread.sleep(30 * 1000000L);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
