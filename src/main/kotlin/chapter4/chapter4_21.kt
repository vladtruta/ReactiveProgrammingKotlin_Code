package chapter4

import io.reactivex.Flowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val flowable = Flowable.interval(100, TimeUnit.MILLISECONDS) // (1)
    flowable.buffer(1, TimeUnit.SECONDS) // (2)
        .subscribe { println(it) }

    runBlocking { delay(5 * 1000L) } // (3)
}