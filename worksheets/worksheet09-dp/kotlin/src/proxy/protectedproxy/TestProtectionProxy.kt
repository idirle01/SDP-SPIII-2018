package proxy.protectedproxy

fun main(args: Array<String>) {
    val owner: Owner = Owner()

    var reportGenerator: ReportGeneratorProxy =
            ReportGeneratorProtectionProxy(owner)
    owner.reportGenerator = reportGenerator

    val employee: Employee = Employee()
    reportGenerator = ReportGeneratorProtectionProxy(employee)
    employee.reportGenerator = reportGenerator

    println("For owner:")
    println(owner.generateDailyReport())

    println("For employee:")
    println(employee.generateDailyReport())
}
