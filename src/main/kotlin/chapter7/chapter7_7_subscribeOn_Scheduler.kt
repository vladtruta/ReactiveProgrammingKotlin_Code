package chapter7

import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10").toObservable()
        .map { item ->
            println("Mapping $item - ${Thread.currentThread().name}")
            return@map item.toInt()
        }
        .subscribeOn(Schedulers.computation()) // (1)
        .subscribe { item ->
            println("Received $item - ${Thread.currentThread().name}")
        }

    runBlocking { delay(1000) }
}