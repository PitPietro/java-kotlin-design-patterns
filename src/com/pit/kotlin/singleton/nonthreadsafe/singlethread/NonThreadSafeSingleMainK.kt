package com.pit.kotlin.singleton.nonthreadsafe.singlethread

import com.pit.kotlin.singleton.nonthreadsafe.NonThreadSafeSingletonK


object NonThreadSafeSingleMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val msg = """
            If you see the same value, then singleton was reused
            If you see different values, then 2 singletons were created
            RESULT:
            """.trimIndent()
        println(msg)
        val singleton = NonThreadSafeSingletonK.getInstance("ABC")
        val anotherSingleton = NonThreadSafeSingletonK.getInstance("123")
        println(singleton?.value)
        println(anotherSingleton?.value)
    }
}