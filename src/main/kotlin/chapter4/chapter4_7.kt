package chapter4

import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

fun main(args: Array<String>) {
    Flowable.range(1, 15)
        .map { MyItem6(it) }
        .observeOn(Schedulers.io())
        .subscribe(object : Subscriber<MyItem6> {

            lateinit var subscription: Subscription // (1)

            override fun onSubscribe(subscription: Subscription?) {
                this.subscription = subscription!!
                subscription.request(5) // (2)
            }

            override fun onNext(item: MyItem6?) {
                runBlocking { delay(50) }
                println("Subscriber received $item")
                // (3)
                if (item?.id == 5) {
                    println("Requesting two more")
                    subscription.request(2) // (4)
                }
            }

            override fun onError(t: Throwable?) {
                t?.printStackTrace()
            }

            override fun onComplete() {
                println("Done!")
            }
        })

    runBlocking { delay(10000) }
}

data class MyItem6(val id: Int) {
    init {
        println("MyItem Created $id")
    }
}