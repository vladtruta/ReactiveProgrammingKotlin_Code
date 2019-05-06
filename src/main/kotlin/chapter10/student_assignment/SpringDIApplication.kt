package chapter10.student_assignment

import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext(Configuration::class.java)
    val student = context.getBean(Student::class.java)

    student.completeAssignment("One")
    student.completeAssignment("Two")
    student.completeAssignment("Three")

    context.close()
}