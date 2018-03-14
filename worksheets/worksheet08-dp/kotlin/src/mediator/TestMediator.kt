package mediator

fun main(args: Array<String>) {
    val sensor = Sensor()
    val soilRemoval = SoilRemoval()
    val motor = Motor()
    val machine = Machine()
    val heater = Heater()
    val valve = Valve()
    val button = Button()

    var mediator: MachineMediator = CottonMediator(machine, heater, motor, sensor, soilRemoval, valve)

    button.setMediator(mediator)
    machine.setMediator(mediator)
    heater.setMediator(mediator)
    valve.setMediator(mediator)

    button.press()

    println("*".repeat(20))

    mediator = DenimMediator(machine, heater, motor, sensor, soilRemoval, valve)
    button.setMediator(mediator)
    machine.setMediator(mediator)
    heater.setMediator(mediator)
    valve.setMediator(mediator)
    button.press()
}
