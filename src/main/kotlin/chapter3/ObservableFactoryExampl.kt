package chapter3

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observer: Observer<Any> = object : Observer<Any> {
        override fun onComplete() {
            println("All Completed")
        }

        override fun onNext(item: Any) {
            println("Next $item")
        }

        override fun onError(e: Throwable) {
            println("Error Occured ${e.message}")
        }

        override fun onSubscribe(d: Disposable) {
            println("New Subscription")
        }
    } // Create Observer

    Observable.range(1, 10).subscribe(observer) // (1)
    Observable.empty<String>().subscribe(observer) // (2)

    runBlocking {
        Observable.interval(300, TimeUnit.MILLISECONDS).subscribe(observer) // (3)
        delay (900)
        Observable.timer(400, TimeUnit.MILLISECONDS).subscribe(observer) // (4)
        delay(450)
    }
}