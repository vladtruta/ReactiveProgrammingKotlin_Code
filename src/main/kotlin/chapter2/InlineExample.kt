package chapter2

@Suppress("NOTHING_TO_INLINE")
inline fun doSomeStuff(a: Int = 0) = a + (a * a)

fun main(args: Array<String>) {
    for (i in 1..10) {
        println("$i Output ${doSomeStuff(i)}")
    }
}