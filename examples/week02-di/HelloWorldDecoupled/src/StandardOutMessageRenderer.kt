class StandardOutMessageRenderer {

    var messageProvider: HelloWorldMessageProvider? = null

    fun render() {
        if (messageProvider == null) {
            throw RuntimeException(
                    "You must set the property messageProvider of class:" + StandardOutMessageRenderer::class.java.name)
        }

        println(messageProvider!!.message)
    }
}