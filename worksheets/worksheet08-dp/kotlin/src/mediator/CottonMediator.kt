package mediator

class CottonMediator(
        private val machine: Machine,
        private val heater: Heater,
        private val motor: Motor,
        private val sensor: Sensor,
        private val soilRemoval: SoilRemoval,
        private val valve: Valve
) : MachineMediator {

    val SPACING = 15
    val DRUM_SPEED = 700
    val TEMPERATURE = 40

    init {
        println(".".repeat(SPACING) + "Setting up for COTTON program" + ".".repeat(SPACING))
    }

    override fun start() = machine.start()

    override fun wash() {
        motor.startMotor()
        motor.rotateDrum(DRUM_SPEED)
        println("Adding detergent")
        soilRemoval.low()
        println("Adding softener")
    }

    override fun open() {
        valve.open()
    }

    override fun closed() {
        valve.closed()
    }

    override fun on() {
        heater.on(TEMPERATURE)
    }

    override fun off() {
        heater.off()
    }

    override fun checkTemperature(temp: Int): Boolean {
        return sensor.checkTemperature(temp)
    }
}
