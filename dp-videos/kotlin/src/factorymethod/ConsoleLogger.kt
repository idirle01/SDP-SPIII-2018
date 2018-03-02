package factorymethod;

import java.lang.System.err

class ConsoleLogger : Logger {
    override fun error(msg: String) {

        err.println("ERROR: " + msg)
    }

    override fun debug(msg: String) {

        err.println("DEBUG: " + msg)
    }
}