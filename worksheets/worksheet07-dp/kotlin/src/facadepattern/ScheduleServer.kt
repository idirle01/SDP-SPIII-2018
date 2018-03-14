package facadepattern

interface ScheduleServer {
    fun startBooting()
    fun readSystemConfigFile()
    fun initializeContext()
    fun initializeListeners()
    fun createSystemObjects()
    fun releaseProcesses()
    fun destory()
    fun destroySystemObjects()
    fun destoryListeners()
    fun destoryContext()
    fun shutdown()
}