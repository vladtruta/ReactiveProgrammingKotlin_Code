package chapter8

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import rx.Observable
import rx.schedulers.Schedulers


fun main(args: Array<String>) {
    Observable.range(1, 10)
        .subscribeOn(Schedulers.computation())
        .subscribe { item -> println("Received $item") }

    runBlocking { delay(10) }
}