package chapter10.employee_task

class SoftwareDeveloper(private val task: ProgrammingTask) : Employee {

    override fun executeTask() {
        task.execute()
    }
}