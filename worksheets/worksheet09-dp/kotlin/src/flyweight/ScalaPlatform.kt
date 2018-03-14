package flyweight

class ScalaPlatform : Platform {
    init {
        println("ScalaPlatform object created")
    }

    override fun execute(code: Code) {
        println("Compiling and executing Scala code.")
    }
}
