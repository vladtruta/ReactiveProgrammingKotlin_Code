package chapter6

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main(args: Array<String>) {
    Observable.range(1, 10)
        .switchMap {
            val randDelay = Random.nextInt(10)
            if (it % 3 == 0)
                Observable.just(it)
            else
                Observable.just(it)
                    .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}