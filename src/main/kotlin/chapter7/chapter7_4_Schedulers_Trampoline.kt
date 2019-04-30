package chapter7

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {

    GlobalScope.async {
        Observable.range(1, 10)
            .subscribeOn(Schedulers.trampoline()) // (1)
            .subscribe {
                runBlocking { delay(200) }
                println("Observable1 Item Received $it")
            }

        Observable.range(21, 10)
            .subscribeOn(Schedulers.trampoline()) // (2)
            .subscribe {
                runBlocking { delay(100) }
                println("Observable2 Item Received $it")
            }

        for (i in 1..10) {
            delay(100)
            println("Blocking Thread $i")
        }
    }

    runBlocking { delay(6000) }
}