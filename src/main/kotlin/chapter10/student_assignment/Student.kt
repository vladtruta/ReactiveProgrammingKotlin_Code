package chapter10.student_assignment

class Student(private val assignment: Assignment) {
    fun completeAssignment(assignmentDtl: String) {
        assignment.performAssignment(assignmentDtl)
    }
}