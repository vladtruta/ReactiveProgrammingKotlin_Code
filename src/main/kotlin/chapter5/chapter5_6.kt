package chapter5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val observable = Observable.range(1, 10)

    observable.first(2) // (1)
        .subscribeBy { item -> println("Received $item") }

    observable.last(2) // (2)
        .subscribeBy { item -> println("Received $item") }

    Observable.empty<Int>().first(2) // (3)
        .subscribeBy { item -> println("Received $item") }
}