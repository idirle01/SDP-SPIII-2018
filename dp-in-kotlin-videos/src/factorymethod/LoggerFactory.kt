package factorymethod

abstract class LoggerFactory {

    abstract val logger: Logger

    companion object {
        @Throws(Exception::class)
        fun getFactory(f: String): LoggerFactory {
            return Class.forName(f).getConstructor().newInstance() as LoggerFactory
        }
    }
}
