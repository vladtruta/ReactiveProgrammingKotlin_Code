package chapter6

import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable1 = Observable.range(1, 10)
    val observable2 = listOf(
        "String 1", "String 2",
        "String 3", "String 4", "String 5", "String 6",
        "String 7", "String 8", "String 9", "String 10"
    )

    observable1.zipWith(observable2) { e1: Int, e2: String ->
        "$e2 $e1"
    }.subscribe {
        println("Received $it")
    }
}