package com.pit.java.singleton.threadsafe;

public class ThreadSafeSingletonMain {
    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused\n" +
                "If you see different values, then 2 singletons were created\n\n" +
                "RESULT:");
        Thread threadFoo = new Thread(new ThreadA());
        Thread threadBar = new Thread(new ThreadB());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("ABC");
            System.out.println(singleton.value);
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance("123");
            System.out.println(singleton.value);
        }
    }
}
