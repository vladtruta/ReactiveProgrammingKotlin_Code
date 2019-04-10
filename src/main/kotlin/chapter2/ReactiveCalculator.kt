package chapter2

import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.util.regex.Pattern

@Suppress("NOTHING_TO_INLINE")
class ReactiveCalculator(a: Int, b: Int) {

    private val subjectCalc: Subject<ReactiveCalculator> = PublishSubject.create()

    var nums: Pair<Int, Int> = Pair(0, 0)

    init {
        nums = Pair(a, b)

        subjectCalc.subscribe {
            with(it) {
                calculateAddition()
                calculateSubtraction()
                calculateMultiplication()
                calculateDivision()
            }
        }

        subjectCalc.onNext(this)
    }

    private inline fun calculateAddition(): Int {
        val result = nums.first + nums.second
        println("Add = $result")
        return result
    }

    private inline fun calculateSubtraction(): Int {
        val result = nums.first - nums.second
        println("Substract = $result")
        return result
    }

    private inline fun calculateMultiplication(): Int {
        val result = nums.first * nums.second
        println("Multiply = $result")
        return result
    }

    private inline fun calculateDivision(): Double {
        val result = (nums.first * 1.0) / (nums.second * 1.0)
        println("Division = $result")
        return result
    }

    private inline fun modifyNumbers(a: Int = nums.first, b: Int = nums.second) {
        nums = Pair(a, b)
        subjectCalc.onNext(this)
    }

    suspend fun handleInput(inputLine: String?) { // (1)
        if (!inputLine.equals("exit")) {
            var a: Int? = null
            var b: Int? = null

            val pattern = Pattern.compile("([a|b])(?:\\s)?=(?:\\s)?(\\d*)")
            val matcher = pattern.matcher(inputLine)

            if (matcher.matches() && matcher.group(1) != null && matcher.group(2) != null) {
                if (matcher.group(1).toLowerCase() == "a") {
                    a = matcher.group(2).toInt()
                } else if (matcher.group(1).toLowerCase() == "b") {
                    b = matcher.group(2).toInt()
                }
            }

            when {
                a != null && b != null -> modifyNumbers(a, b)
                a != null -> modifyNumbers(a = a)
                b != null -> modifyNumbers(b = b)
                else -> println("Invalid Input")
            }
        }
    }
}

fun main(args: Array<String>) {
    println("Initial Output with a = 15, b = 10")
    val calculator = ReactiveCalculator(15, 10)

    println("Enter a = <number> or b = <number> in separate lines\nexit to exit the program")
    var line: String?
    do {
        line = readLine()

        // (2)
        GlobalScope.async {
            calculator.handleInput(line)
        }
    } while (line != null && !line.toLowerCase().contains("exit"))
}
