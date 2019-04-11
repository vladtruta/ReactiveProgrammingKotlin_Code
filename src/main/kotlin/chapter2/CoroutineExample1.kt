package chapter2

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

suspend fun longRunningTsk(): Long { // (1)
    return measureTimeMillis { // (2)
        println("Please wait")
        delay(TimeUnit.SECONDS.toMillis(2))
        println("Delay Over")
    }
}

fun main(args: Array<String>) {
    runBlocking { // (4)
        val exeTime = longRunningTsk() // (5)
        println("Execution Time is $exeTime")
    }
}