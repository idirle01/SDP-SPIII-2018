package mediator

class DenimMediator(
        private val machine: Machine,
        private val heater: Heater,
        private val motor: Motor,
        private val sensor: Sensor,
        private val soilRemoval: SoilRemoval,
        private val valve: Valve
) : MachineMediator {

    val SPACING = 15
    val DRUM_SPEED = 1400
    val TEMPERATURE = 30

    init {
        println(".".repeat(SPACING) + "Setting up for DENIM program" + ".".repeat(SPACING))
    }

    override fun start() {
        machine.start()
    }

    override fun wash() {
        motor.startMotor()
        motor.rotateDrum(DRUM_SPEED)
        println("Adding detergent")
        soilRemoval.medium()
        println("No softener is required")
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
