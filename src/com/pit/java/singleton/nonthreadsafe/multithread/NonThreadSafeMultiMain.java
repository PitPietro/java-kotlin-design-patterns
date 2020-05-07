package com.pit.java.singleton.nonthreadsafe.multithread;

import com.pit.java.singleton.nonthreadsafe.NonThreadSafeSingleton;

public class NonThreadSafeMultiMain {
    public static void main(String[] args) {
        String msg = "If you see the same value, then singleton was reused\n" +
                "If you see different values, then 2 singletons were created\n" +
                "RESULT:";
        System.out.println(msg);
        Thread threadA = new Thread(new ThreadA());
        Thread threadB = new Thread(new ThreadB());
        threadA.start();
        threadB.start();
    }

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            NonThreadSafeSingleton singleton = NonThreadSafeSingleton.getInstance("ABC");
            System.out.println(singleton.value);
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            NonThreadSafeSingleton singleton = NonThreadSafeSingleton.getInstance("123");
            System.out.println(singleton.value);
        }
    }
}
