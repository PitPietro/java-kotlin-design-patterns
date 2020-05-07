package com.pit.java.singleton.nonthreadsafe.singlethread;

import com.pit.java.singleton.nonthreadsafe.NonThreadSafeSingleton;

public class NonThreadSafeSingleMain {
    public static void main(String[] args) {
        String msg = "If you see the same value, then singleton was reused\n" +
                "If you see different values, then 2 singletons were created\n" +
                "RESULT:";
        System.out.println(msg);
        NonThreadSafeSingleton singleton = NonThreadSafeSingleton.getInstance("ABC");
        NonThreadSafeSingleton anotherSingleton = NonThreadSafeSingleton.getInstance("123");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
