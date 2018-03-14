package mediator

interface MachineMediator {
    fun start()
    fun wash()
    fun open()
    fun closed()
    fun on()
    fun off()
    fun checkTemperature(temp: Int): Boolean
}
