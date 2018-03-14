package chain

interface Handler {
    fun setHandler(handler: Handler)
    fun process(file: File)
    fun getHandlerName(): String
}
