package chapter10.aop_student_assignment

import kotlin.random.Random

open class Faculty {
    open fun evaluateAssignment(): Int {
        val marks = Random.nextInt(10)
        println("This assignment is evaluated and given $marks points")

        return marks
    }
}