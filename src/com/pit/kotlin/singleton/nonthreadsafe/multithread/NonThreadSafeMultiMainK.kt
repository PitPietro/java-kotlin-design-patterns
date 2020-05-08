package com.pit.kotlin.singleton.nonthreadsafe.multithread

import com.pit.kotlin.singleton.nonthreadsafe.NonThreadSafeSingletonK

object NonThreadSafeMultiMainK {
    @JvmStatic
    fun main(args: Array<String>) {
        val msg = """
            If you see the same value, then singleton was reused
            If you see different values, then 2 singletons were created
            RESULT:
            """.trimIndent()
        println(msg)
        val threadA = Thread(ThreadA())
        val threadB = Thread(ThreadB())
        threadA.start()
        threadB.start()
    }

    internal class ThreadA : Runnable {
        override fun run() {
            val singleton = NonThreadSafeSingletonK.getInstance("ABC")
            println(singleton?.value)
        }
    }

    internal class ThreadB : Runnable {
        override fun run() {
            val singleton = NonThreadSafeSingletonK.getInstance("123")
            println(singleton?.value)
        }
    }
}
