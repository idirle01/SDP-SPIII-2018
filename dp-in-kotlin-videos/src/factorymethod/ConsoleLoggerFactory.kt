package factorymethod

class ConsoleLoggerFactory : LoggerFactory() {
    override val logger: Logger
        get() = ConsoleLogger()
}