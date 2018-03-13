package singleton

object Singleton

class SingletonWithCons private constructor() {

    init {
        counter++
    }

    override fun toString(): String {
        return javaClass.toString() + " " + hashCode() + " " + counter
    }

    companion object {
        var counter = 0
        var instance: SingletonWithCons? = null
            private set

        init {
            instance = SingletonWithCons()
        }
    }
}

fun main(args: Array<String>) {
    val LIMIT = 10
    println(SingletonWithCons.counter)
    for (x in 0 until LIMIT) {
        println(SingletonWithCons.instance)
    }
}