package chapter4

import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val source = Observable.range(1, 1000) // (1)

    source.toFlowable(BackpressureStrategy.BUFFER) // (2)
        .map { MyItem7(it) }
        .observeOn(Schedulers.computation())
        .subscribe {
            println("Rec. $it;\t")
            runBlocking { delay(600) }
        }

    runBlocking { delay(700000) }
}

data class MyItem7(val id: Int) {
    init {
        println("MyItem7 init $id;\t")
    }
}