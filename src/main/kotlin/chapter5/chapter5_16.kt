package chapter5

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main(args: Array<String>) {
    Observable.range(1, 10)
        .reduce { previousAccumulation, newEmission ->
            previousAccumulation + newEmission
        }
        .subscribeBy(
            onSuccess = { println("accumulation $it") }
        )

    Observable.range(1, 5)
        .reduce { previousAccumulation, newEmission ->
            previousAccumulation * 10 + newEmission
        }
        .subscribeBy(
            onSuccess = { println("accumulation $it") }
        )
}