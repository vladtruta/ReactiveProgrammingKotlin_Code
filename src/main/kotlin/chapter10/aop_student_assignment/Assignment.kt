package chapter10.aop_student_assignment

open class Assignment {
    open fun performAssignment(assignmentDtl: String) {
        println("Performing Assignment $assignmentDtl")
    }
}