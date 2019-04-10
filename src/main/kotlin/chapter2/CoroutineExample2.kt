package chapter2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val time = GlobalScope.async { longRunningTsk() }
    println("Print after async")
    runBlocking { println("printing time: ${time.await()}") }
}