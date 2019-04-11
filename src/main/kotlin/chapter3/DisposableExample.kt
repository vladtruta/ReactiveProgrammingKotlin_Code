package chapter3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    runBlocking {
        var observable: Observable<Long> = Observable.interval(100, TimeUnit.MILLISECONDS) // (1)
        val observer: Observer<Long> = object : Observer<Long> {

            lateinit var disposable: Disposable // (2)

            override fun onSubscribe(d: Disposable) {
                disposable = d // (3)
            }

            override fun onNext(item: Long) {
                println("Received $item")
                if (item >= 10 && !disposable.isDisposed) { // (4)
                    disposable.dispose()
                    println("Disposed")
                }
            }

            override fun onError(e: Throwable) {
                println("Error ${e.message}")
            }

            override fun onComplete() {
                println("Complete")
            }
        }

        observable.subscribe(observer)
        delay(1500) // (6)
    }
}