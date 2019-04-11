package chapter2

import io.reactivex.Maybe
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    val maybeValue: Maybe<Int> = Maybe.just(4) // (1)
    maybeValue.subscribeBy( // (2)
        onComplete = { println("Completed empty") },
        onError = { println("Error $it") },
        onSuccess = { println("Completed with value $it") }
    )

    val maybeEmpty: Maybe<Int> = Maybe.empty() // (3)
    maybeEmpty.subscribeBy(
        onComplete = { println("Completed empty") }, // (4)
        onError = { println("Error $it") }, // (5)
        onSuccess = { println("Completed with value $it") } // (6)
    )
}