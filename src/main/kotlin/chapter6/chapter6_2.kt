package chapter6

import io.reactivex.Observable
import io.reactivex.functions.BiFunction

fun main(args: Array<String>) {
    val observable1 = Observable.range(1, 10)
    val observable2 = Observable.range(11, 10)

    Observable.zip(observable1, observable2, BiFunction<Int, Int, Int> { emission1, emission2 ->
        emission1 + emission2
    }).subscribe {
        println("Received $it")
    }
}