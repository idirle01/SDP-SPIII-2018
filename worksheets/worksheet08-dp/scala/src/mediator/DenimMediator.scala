package mediator

class DenimMediator(
  private val machine: Machine,
  private val heater: Heater,
  private val motor: Motor,
  private val sensor: Sensor,
  private val soilRemoval: SoilRemoval,
  private val valve: Valve
)
  extends MachineMediator {

  val SPACING = 15
  val DRUM_SPEED = 1400
  val TEMPERATURE = 30

  println("." * SPACING + "Setting up for DENIM program" + "." * SPACING)

  override def start(): Unit = machine.start

  override def wash(): Unit = {
    motor.startMotor()
    motor.rotateDrum(DRUM_SPEED)
    println("Adding detergent")
    soilRemoval.medium()
    println("No softener is required")
  }

  override def open(): Unit = valve.open

  override def closed(): Unit = valve.closed

  override def on(): Unit = heater.on(TEMPERATURE)

  override def off(): Unit = heater.off

  override def checkTemperature(temp: Int): Boolean =
    sensor.checkTemperature(temp)
}
