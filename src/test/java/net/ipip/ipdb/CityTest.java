package net.ipip.ipdb;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CityTest {

    private static City cityDb;

    static {
        try {
            cityDb = new City("c:/work/ipdb/mydata4vipweek2.ipdb");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testCityWeek2() {

        try {
            City db = new City("c:/tiantexin/17mon/ipipfree.ipdb");
            System.out.println(db.buildTime());
            System.out.println(db.languages());
            System.out.println(db.fields());
            System.out.println(db.isIPv4());
            System.out.println(db.isIPv6());

            System.out.println(Arrays.toString(db.find("123.125.71.96", "CN")));
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

    /**
     * 多线程测试
     */
    @Test
    public void find() {
        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000(),
                () -> test10000()                ,
                () -> test10000()
        );

        try {
            executor.invokeAll(callables)
                    .stream()
                    .map(future -> {
                        try {
                            return future.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }



    private String test10000() throws IPFormatException, InvalidDatabaseException {
        long t0 = System.currentTimeMillis();
        int count = 10000;
        for (int i = 0; i < count; i++) {
            String randomIp = IpUtils.getRandomIp();
            final String result = Arrays.toString(cityDb.find(randomIp, "CN"));
        }
        System.out.println("test10000() use time: TimeMillis: " + (System.currentTimeMillis() - t0));
        return "test10000";
    }
}
