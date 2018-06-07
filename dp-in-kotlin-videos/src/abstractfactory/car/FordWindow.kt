package abstractfactory.car

class FordWindow : CarWindow {
    override fun toString(): String {
        return javaClass.toString()
    }
}
