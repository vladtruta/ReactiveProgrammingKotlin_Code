package chapter6

import io.reactivex.Observable

fun main(args: Array<String>) {
    val observable = Observable.range(1, 30)

    // (1)
    observable.groupBy {
        it % 5
    } //(2)
        .subscribe { groupedObservable ->
            println("Key ${groupedObservable.key}")

            // (3)
            groupedObservable.subscribe {
                println("Received $it")
            }
        }
}