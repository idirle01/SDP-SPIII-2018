package abstractfactory.car

class Car(private val mFactory: CarFactoryInterface) {

    private val mWindow: CarWindow
    private val mEngine: CarEngine

    init {
        // Use the factory to fill in the parts
        mWindow = mFactory.window
        mEngine = mFactory.engine
    }

}
