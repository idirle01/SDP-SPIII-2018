package proxy.remoteproxy

import java.rmi.Remote

interface ReportGenerator : Remote {
    fun generateDailyReport(): String
}
