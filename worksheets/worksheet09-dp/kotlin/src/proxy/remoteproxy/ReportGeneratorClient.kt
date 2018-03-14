package proxy.remoteproxy

import java.rmi.Naming

fun main(args: Array<String>) {
    TODO()
}

class ReportGeneratorClient {
    fun generateReport() {
        try {
            val reportGenerator: ReportGenerator = Naming
                    .lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator")
                    as ReportGenerator
            println(reportGenerator.generateDailyReport())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
