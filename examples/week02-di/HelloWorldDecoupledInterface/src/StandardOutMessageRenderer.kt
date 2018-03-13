class StandardOutMessageRenderer : MessageRenderer {

    override var messageProvider: MessageProvider? = null

    override fun render() {
        if (messageProvider == null) {
            throw RuntimeException(
                    "You must set the property messageProvider of class:" + StandardOutMessageRenderer::class.java!!.getName())
        }

        println(messageProvider!!.message)
    }
}