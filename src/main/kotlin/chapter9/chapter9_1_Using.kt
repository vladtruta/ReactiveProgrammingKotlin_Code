package chapter9

import io.reactivex.Observable
import java.io.Closeable

fun main(args: Array<String>) {
    Observable.using({
        Resource()
    }, { resource ->
        Observable.just(resource)
    }, { resource ->
        resource.close()
    }).subscribe {
        println("Resource Data ${it.data}")
    }
}

class Resource : Closeable {
    init {
        println("Resource Created")
    }

    val data: String = "Hello World"

    override fun close() {
        println("Resource Closed")
    }
}