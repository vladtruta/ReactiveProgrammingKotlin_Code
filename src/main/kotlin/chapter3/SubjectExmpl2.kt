package chapter3

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val observable = Observable.interval(100, TimeUnit.MILLISECONDS) // (1)
    val subject = PublishSubject.create<Long>() // (2)

    observable.subscribe(subject) // (3)

    // (4)
    subject.subscribe {
        println("Subscription 1 Received $it")
    }
    runBlocking { delay(1100) } // (5)

    // (6)
    subject.subscribe {
        println("Subscription 2 Received $it")
    }
    runBlocking { delay(1100) } // (7)
}