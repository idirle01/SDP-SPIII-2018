package abstractfactory.car

class BMWFactory : CarFactoryInterface {

    override val engine: CarEngine
        get() = BMWEngine()

    override val window: CarWindow
        get() = BMWWindow()

}
