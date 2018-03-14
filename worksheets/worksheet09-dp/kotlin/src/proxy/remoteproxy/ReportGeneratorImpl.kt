package proxy.remoteproxy

import java.rmi.Naming
import java.rmi.server.UnicastRemoteObject

fun main(args: Array<String>) {
    try {
        val reportGenerator: ReportGenerator = ReportGeneratorImpl()
        Naming.rebind("PizzaCoRemoteGenerator", reportGenerator)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

class ReportGeneratorImpl()
    : UnicastRemoteObject(), ReportGenerator {

    override fun generateDailyReport(): String {
        TODO()
    }
}
