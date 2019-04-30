package chapter5

import io.reactivex.Observable

fun main(args: Array<String>) {
    Observable.range(1, 20) // (1)
        // (2)
        .filter {
            it % 2 == 0
        }
        .subscribe {
            println("Received $it")
        }
}