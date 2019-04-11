package chapter2

fun square(n: Int): Int = n * n // (1)

fun main(args: Array<String>) {
    println("named pure func chapter2.square = ${square(3)}")
    val qube = { n: Int -> n * n * n } // (2)
    println("lambda pure func qube = ${qube(3)}")
}