package chapter6

import org.apache.http.impl.nio.client.HttpAsyncClients
import rx.apache.http.ObservableHttp

fun main(args: Array<String>) {
    val httpClient = HttpAsyncClients.createDefault() // (1)
    httpClient.start() // (2)

    ObservableHttp.createGet("https://jsonplaceholder.typicode.com/posts", httpClient).toObservable() // (3)
        .flatMap { response ->
            response.content.map { bytes ->
                String(bytes)
            } // (4)
        }
        .onErrorReturn { "Error parsing data " } // (5)
        .subscribe {
            println(it) // (6)
            httpClient.close() // (7)
        }
}