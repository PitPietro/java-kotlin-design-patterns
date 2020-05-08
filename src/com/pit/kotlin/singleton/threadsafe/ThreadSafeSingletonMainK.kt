package com.pit.kotlin.singleton.threadsafe

object ThreadSafeSingletonMainK {
    @JvmStatic
    fun main(args: Array<String>) {
        println("""
    If you see the same value, then singleton was reused
    If you see different values, then 2 singletons were created
    
    RESULT:
    """.trimIndent())
        val threadFoo = Thread(ThreadA())
        val threadBar = Thread(ThreadB())
        threadFoo.start()
        threadBar.start()
    }

    internal class ThreadA : Runnable {
        override fun run() {
            val singleton = ThreadSafeSingletonK.getInstance("ABC")
            println(singleton?.value)
        }
    }

    internal class ThreadB : Runnable {
        override fun run() {
            val singleton = ThreadSafeSingletonK.getInstance("123")
            println(singleton?.value)
        }
    }
}