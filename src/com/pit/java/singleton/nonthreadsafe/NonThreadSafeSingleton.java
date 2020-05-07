package com.pit.java.singleton.nonthreadsafe;

public final class NonThreadSafeSingleton {
    private static NonThreadSafeSingleton instance;
    public String value;

    private NonThreadSafeSingleton(String value) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static NonThreadSafeSingleton getInstance(String value) {
        if (instance == null) {
            instance = new NonThreadSafeSingleton(value);
        }
        return instance;
    }
}