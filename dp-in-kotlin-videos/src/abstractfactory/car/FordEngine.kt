package abstractfactory.car

class FordEngine : CarEngine {
    override fun toString(): String {
        return javaClass.toString()
    }
}
