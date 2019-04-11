package chapter3

import io.reactivex.Observable
import io.reactivex.rxkotlin.toObservable

fun main(args: Array<String>) {
    val observable: Observable<String> = listOf("String 1", "String 2", "String 3", "String 4").toObservable() // (1)

    // (2)
    observable.subscribe({
        // onNext
        println("Received $it")
    }, {
        // onError
        println("Error ${it.message}")
    }, {
        // onComplete
        println("Done")
    })

    // (3)
    observable.subscribe({
        // onNext
        println("Received $it")
    }, {
        // onError
        println("Error ${it.message}")
    }, {
        // onComplete
        println("Done")
    })
}