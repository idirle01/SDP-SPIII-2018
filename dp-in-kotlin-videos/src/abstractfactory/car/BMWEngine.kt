package abstractfactory.car

class BMWEngine : CarEngine {
    override fun toString(): String {
        return javaClass.toString()
    }
}
