package mediator

class Button : Colleague {

    lateinit private var mediator: MachineMediator

    override fun setMediator(mediator: MachineMediator) {
        this.mediator = mediator
    }

    fun press() {
        println("Button pressed.")
        mediator.start()
    }
}
