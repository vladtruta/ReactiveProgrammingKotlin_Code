package chapter4

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    Flowable.range(1, 1000) // (1)
        .map { MyItem4(it) }
        .observeOn(Schedulers.computation())
        // (3)
        .subscribe({
            println("Received $it;\t")
            runBlocking { delay(50) } // (4)
        }, {
            it.printStackTrace()
        })

    runBlocking { delay(70000) } // (5)
}

data class MyItem4(val id: Int) {
    init {
        println("MyItem Created $id;\t")
    }
}