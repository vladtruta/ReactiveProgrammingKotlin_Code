package chapter10.aop_student_assignment

open class Student(private val assignment: Assignment) {
    open fun completeAssignment(assignmentDtl: String) {
        assignment.performAssignment(assignmentDtl)
    }
}