package chapter2
fun Int.isEven() = this % 2 == 0

fun highOrderFunc(a: Int, validityCheckFunc: (a: Int) -> Boolean) { // (1)
    if (validityCheckFunc(a)) {
        println("a $a is Valid")
    } else {
        println("a $a is Invalid")
    }
}

fun main(args: Array<String>) {
    highOrderFunc(12) { a: Int -> a.isEven() } // (3)
    highOrderFunc(19) { a: Int -> a.isEven() }
}