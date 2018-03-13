package reflection

open class BaseClass {

    var baseInt: Int = 0

    open fun method4(): Int {
        println("Method4")
        return 0
    }

    internal fun method6() {
        println("Method6")
    }

    // inner public class
    inner class BaseClassInnerClass

    //member public enum
    enum class BaseClassMemberEnum

    companion object {

        private fun method3() {
            println("Method3")
        }

        fun method5(): Int {
            println("Method5")
            return 0
        }
    }
}