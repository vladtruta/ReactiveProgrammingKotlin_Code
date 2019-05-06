package chapter10.employee_task

class RandomEmployee : Employee {
    private val task = RandomTask()

    override fun executeTask() {
        task.execute()
    }
}