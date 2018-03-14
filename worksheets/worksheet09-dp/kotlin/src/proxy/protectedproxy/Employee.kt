package proxy.protectedproxy

class Employee : Staff {
    override var reportGenerator: ReportGeneratorProxy = TODO()

    override fun isOwner(): Boolean = false

    fun generateDailyReport(): String = TODO()
}
