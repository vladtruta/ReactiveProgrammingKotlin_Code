package chapter7

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import rx.Observable

fun main(args: Array<String>) {

    Observable.range(1, 10)
        .subscribe {
            runBlocking { delay(200) }
            println("Observable1 Item Received $it")
        }

    Observable.range(21, 10)
        .subscribe {
            runBlocking { delay(100) }
            println("Observable2 Item Received $it")
        }
}