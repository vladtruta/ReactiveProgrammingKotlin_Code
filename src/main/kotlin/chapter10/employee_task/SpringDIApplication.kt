package chapter10.employee_task

import org.springframework.context.support.ClassPathXmlApplicationContext

fun main(args: Array<String>) {

    // Without Dependency Injection
    val randomEmployee = RandomEmployee()
    randomEmployee.executeTask()

    // With Dependency Injection
    val context = ClassPathXmlApplicationContext("META-INF/spring/employee.xml")

    val employee = context.getBean(Employee::class.java)
    employee.executeTask()

    context.close()
}