package chapter4

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observer: Observer<Int> = object : Observer<Int> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Int) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }
    } // Create Observer

    // (1)
    val observable: Observable<Int> = Observable.create<Int> {
        for (i in 1..10) {
            it.onNext(i)
        }
        it.onComplete()
    }

    observable.subscribe(observer)
}