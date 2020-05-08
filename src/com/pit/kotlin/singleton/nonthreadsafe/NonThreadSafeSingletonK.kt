package com.pit.kotlin.singleton.nonthreadsafe

class NonThreadSafeSingletonK private constructor(value: String) {
    var value: String

    companion object {
        private var instance: NonThreadSafeSingletonK? = null
        fun getInstance(value: String): NonThreadSafeSingletonK? {
            if (instance == null) {
                instance = NonThreadSafeSingletonK(value)
            }
            return instance
        }
    }

    init {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
        this.value = value
    }
}