package chapter4

import io.reactivex.processors.PublishProcessor
import io.reactivex.rxkotlin.toFlowable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    val flowable = listOf("String 1", "String 2", "String 3", "String 4", "String 5").toFlowable() // (1)

    val processor = PublishProcessor.create<String>() // (2)

    processor.subscribe {
        println("Subscription 1: $it")
        runBlocking { delay(1000) }
        println("Subscription 1 delay")
    }

    processor.subscribe {
        println("Subscription 2 $it")
    }

    flowable.subscribe(processor)
}