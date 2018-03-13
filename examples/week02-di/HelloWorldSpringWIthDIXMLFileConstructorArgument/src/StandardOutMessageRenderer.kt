class StandardOutMessageRenderer : MessageRenderer {

    override lateinit var messageProvider: MessageProvider

    override fun render() {
        if (messageProvider == null) {
            throw RuntimeException(
                    "You must set the property messageProvider of class:" + StandardOutMessageRenderer::class.java.getName())
        }

        println(messageProvider.message)
    }

}