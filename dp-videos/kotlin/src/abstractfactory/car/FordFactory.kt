package abstractfactory.car

class FordFactory : CarFactoryInterface {

    override val engine: CarEngine
        get() = FordEngine()

    override val window: CarWindow
        get() = FordWindow()

}
