package chapter3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.range(1, 5) // (1)

    // (2)
    observable.subscribe({
        // onNext Method
        println("Next $it")
    }, {
        // onError Method
        println("Error ${it.message}")
    }, {
        // onComplete Method
        println("Done")
    })

    // (3)
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
    }
    observable.subscribe(observer)
}