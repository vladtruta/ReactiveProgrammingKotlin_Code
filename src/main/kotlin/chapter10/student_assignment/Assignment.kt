package chapter10.student_assignment

class Assignment(val task: (String) -> Unit) {
    fun performAssignment(assignmentDtl: String) {
        task(assignmentDtl)
    }
}