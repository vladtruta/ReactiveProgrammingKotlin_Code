package chapter4

import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args: Array<String>) {
    Flowable.range(1, 1000) // (1)
        .map { MyItem5(it) } // (2)
        .observeOn(Schedulers.io())
        // (3)
        .subscribe(object : Subscriber<MyItem5> {
            override fun onSubscribe(subscription: Subscription?) {
                subscription?.request(Long.MAX_VALUE) // (4)
            }

            override fun onNext(item: MyItem5?) {
                runBlocking { delay(50) }
                println("Subscriber received $item")
            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onComplete() {
                println("Done!")
            }
        })

    runBlocking { delay(60000) }
}


data class MyItem5(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}