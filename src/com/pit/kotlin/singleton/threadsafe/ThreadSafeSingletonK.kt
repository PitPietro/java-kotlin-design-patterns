package com.pit.kotlin.singleton.threadsafe

class ThreadSafeSingletonK private constructor(var value: String) {

    companion object {
        /**
         * The field must be declared volatile so that double check lock would work correctly.
         */
        @Volatile
        private var instance: ThreadSafeSingletonK? = null

        fun getInstance(value: String): ThreadSafeSingletonK? {
            val result = instance
            if (result != null) {
                return result
            }
            synchronized(ThreadSafeSingletonK::class.java) {
                if (instance == null) {
                    instance = ThreadSafeSingletonK(value)
                }
                return instance
            }
        }
    }
}