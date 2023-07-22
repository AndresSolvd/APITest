package com.solvd.carina.demo;

import java.util.concurrent.*;

public class TestWithThreads {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<String> test1 = executor.submit(new Test1());
        Future<String> test2 = executor.submit(new Test2());
        Future<String> test3 = executor.submit(new Test3());
        Future<String> test4 = executor.submit(new Test4());
        Future<String> test5 = executor.submit(new Test5());

        executor.shutdown();

        try {
            String resultTest1 = test1.get();
            String resultTest2 = test2.get();
            String resultTest3 = test3.get();
            String resultTest4 = test4.get();
            String resultTest5 = test5.get();

            System.out.println(resultTest1);
            System.out.println(resultTest2);
            System.out.println(resultTest3);
            System.out.println(resultTest4);
            System.out.println(resultTest5);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class Test1 implements Callable<String> {

        @Override
        public String call() throws Exception {
            new SauceDemoTest().loginTest();
            return "test 1 completed";
        }
    }

    static class Test2 implements Callable<String> {

        @Override
        public String call() throws Exception {
            new SauceDemoTest().productAddedToTheCartTest();
            return "test 2 completed";
        }
    }

    static class Test3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            new SauceDemoTest().aboutButtonInHamburgerMenuTest();
            return "test 3 completed";
        }
    }

    static class Test4 implements Callable<String> {

        @Override
        public String call() throws Exception {
            new SauceDemoTest().logOutButtonInHamburgerMenuTest();
            return "test 4 completed";
        }
    }

    static class Test5 implements Callable<String> {

        @Override
        public String call() throws Exception {
            new SauceDemoTest().checkoutButtonInCartPage();
            return "test 5 completed";
        }
    }
}