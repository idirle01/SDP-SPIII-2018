package proxy.protectedproxy

interface Staff {
    fun isOwner(): Boolean
    val reportGenerator: ReportGeneratorProxy
}
