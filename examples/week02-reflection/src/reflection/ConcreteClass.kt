package reflection

class ConcreteClass(var publicInt: Int) : BaseClass(), BaseInterface {
    private val privateString = "private string"
    protected var protectedBoolean: Boolean = false
    internal var defaultObject: Any? = null

    override fun method1() {
        println("Method1 impl.")
    }

    override fun method2(str: String): Int {
        println("Method2 impl.")
        return 0
    }

    override fun method4(): Int {
        println("Method4 overriden.")
        return 0
    }

    fun method5(i: Int): Int {
        println("Method4 overriden.")
        return 0
    }

    // inner classes
    inner class ConcreteClassPublicClass

    private inner class ConcreteClassPrivateClass
    protected inner class ConcreteClassProtectedClass
    internal inner class ConcreteClassDefaultClass

    //member enum
    internal enum class ConcreteClassDefaultEnum

    enum class ConcreteClassPublicEnum

    //member interface
    interface ConcreteClassPublicInterface

}