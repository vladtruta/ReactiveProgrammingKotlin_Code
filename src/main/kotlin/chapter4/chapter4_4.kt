package chapter4

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Observable.range(1, 1000) // (1)
        .map { MyItem3(it) } // (2)
        .observeOn(Schedulers.computation())
        // (3)
        .subscribe({
            println("Received $it;\t")
            runBlocking { delay(50) } // (4)
        }, {
            it.printStackTrace()
        })

    runBlocking { delay(80000) } // (5)
}

data class MyItem3(val id: Int) {
    init {
        println("MyItem Created $id;\t")
    }
}