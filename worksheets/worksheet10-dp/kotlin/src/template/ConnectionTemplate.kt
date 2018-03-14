package template

abstract class ConnectionTemplate {

    fun run() {
        setDBDriver()
        setCredentials()
        connect()
        prepareStatement()
        setData()
        insert()
        close()
        destroy()
    }

    fun setDBDriver() {
        TODO()
    }

    fun setCredentials() {
        TODO()
    }

    fun connect() {
        println("Setting connection...")
    }

    fun prepareStatement() {
        println("Preparing insert statement...")
    }

    fun setData() {
        TODO()
    }

    fun insert() {
        println("Inserting data...")
    }

    fun close() {
        println("Closing connections...")
    }

    fun destroy() {
        println("Destroying connection objects...")
    }
}
