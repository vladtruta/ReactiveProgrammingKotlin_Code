package chapter5

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(0, 10) // (1)
        .filter { it > 15 } // (2)
        .subscribe {
            println("Received $it")
        }
}