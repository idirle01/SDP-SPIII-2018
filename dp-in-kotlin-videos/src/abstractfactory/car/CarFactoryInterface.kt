package abstractfactory.car

// An interface is a good choice for the abstract factory itself

interface CarFactoryInterface {
    val window: CarWindow
    val engine: CarEngine
}
