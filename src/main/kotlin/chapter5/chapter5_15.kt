package chapter5

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    listOf(1, 5, 9, 7, 6, 4, 3, 2, 4, 6, 9)
        .toObservable()
        .count()
        .subscribeBy(
            onSuccess = { println("count $it") }
        )
}