package chapter4

import io.reactivex.Flowable

fun main(args: Array<String>) {
    val flowable = Flowable.range(1, 111) // (1)
    flowable.window(10)
        .subscribe { flow ->
            // (2)
            flow.subscribe {
                print("$it, ")
            }
            println()
        }
}