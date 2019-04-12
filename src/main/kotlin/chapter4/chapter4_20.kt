package chapter4

import io.reactivex.Flowable

fun main(args: Array<String>) {
    val flowable = Flowable.range(1, 111)

    flowable.buffer(10, 15) // (1)
        .subscribe { println("Subscription 1 $it") }

    flowable.buffer(15, 7) // (2)
        .subscribe { println("Subscription 2 $it") }
}