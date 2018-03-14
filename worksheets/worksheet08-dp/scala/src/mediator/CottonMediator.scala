package mediator

class CottonMediator(
  private val machine: Machine,
  private val heater: Heater,
  private val motor: Motor,
  private val sensor: Sensor,
  private val soilRemoval: SoilRemoval,
  private val valve: Valve
) extends MachineMediator {

  val SPACING = 15
  val DRUM_SPEED = 700
  val TEMPERATURE = 40

  println("." * SPACING + "Setting up for COTTON program" + "." * SPACING)

  override def start(): Unit = machine.start

  override def wash(): Unit = {
    motor.startMotor()
    motor.rotateDrum(DRUM_SPEED)
    println("Adding detergent")
    soilRemoval.low()
    println("Adding softener")
  }

  override def open(): Unit = valve.open

  override def closed(): Unit = valve.closed

  override def on(): Unit = heater.on(TEMPERATURE)

  override def off(): Unit = heater.off

  override def checkTemperature(temp: Int): Boolean =
    sensor.checkTemperature(temp)
}
