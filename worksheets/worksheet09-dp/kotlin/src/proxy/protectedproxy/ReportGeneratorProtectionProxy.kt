package proxy.protectedproxy

class ReportGeneratorProtectionProxy(var staff: Staff)
    : ReportGeneratorProxy {

    var reportGenerator: ReportGenerator = TODO()

    override fun generateDailyReport(): String =
            if (staff.isOwner()) {
                TODO()
            } else {
                "Not Authorized to view report."
            }
}
