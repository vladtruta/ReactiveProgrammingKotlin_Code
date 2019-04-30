package chapter6

import io.reactivex.Observable
import java.util.concurrent.TimeUnit
import kotlin.random.Random

fun main(args: Array<String>) {
    Observable.range(1, 10)
        .flatMap {
            val randDelay = Random.nextInt(10)

            // (1)
            return@flatMap Observable.just(it)
                .delay(randDelay.toLong(), TimeUnit.MILLISECONDS)
        }
        .blockingSubscribe {
            println("Received $it")
        }
}