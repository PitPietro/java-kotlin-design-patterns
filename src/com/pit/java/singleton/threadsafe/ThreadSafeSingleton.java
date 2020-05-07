package com.pit.java.singleton.threadsafe;

public final class ThreadSafeSingleton {
    // The field must be declared volatile so that double check lock would work correctly.
    private static volatile ThreadSafeSingleton instance;

    public String value;

    private ThreadSafeSingleton(String value) {
        this.value = value;
    }

    /**
     * The approach taken here is called double-checked locking (DCL). It exists to prevent race condition
     * between multiple threads that may attempt to get singleton instance at the same time, creating separate
     * instances as a result. It could seem that having the 'result' variable here is completely pointless.
     * However it is very important to have it when implementing double-checked locking in Java, which is
     * solved by introducing this local variable. You can read more info DCL issues in Java at:
     * https://en.wikipedia.org/wiki/Double-checked_locking#Usage_in_Java
     * @param value attribute
     * @return Singleton class
     */
    public static ThreadSafeSingleton getInstance(String value) {
        ThreadSafeSingleton result = instance;
        if (result != null) {
            return result;
        }
        synchronized(ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton(value);
            }
            return instance;
        }
    }
}
