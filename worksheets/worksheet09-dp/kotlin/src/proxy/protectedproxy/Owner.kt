package proxy.protectedproxy

class Owner : Staff {
    override fun isOwner(): Boolean = TODO()

    override var reportGenerator: ReportGeneratorProxy = TODO()

    fun generateDailyReport(): String = TODO()
}
