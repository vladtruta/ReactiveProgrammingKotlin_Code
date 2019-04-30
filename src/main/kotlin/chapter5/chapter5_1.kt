package chapter5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.just(1, 2, 3, 4, 5, 6, 7, "Error", 8, 9)
        .map { it.toIntOrError() }
        .subscribeBy(
            onNext = {
                println("Next $it")
            },
            onError = {
                println("Error $it")
            }
        )
}