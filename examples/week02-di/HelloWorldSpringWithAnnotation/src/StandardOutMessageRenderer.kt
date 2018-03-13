import org.springframework.beans.factory.annotation.Autowired

class StandardOutMessageRenderer : MessageRenderer {

    @Autowired
    lateinit  var messageProvider: MessageProvider

    override fun render() {
        if (messageProvider == null) {
            throw RuntimeException(
                    "You must set the property messageProvider of class:" + StandardOutMessageRenderer::class.java.getName())
        }

        println(messageProvider.message)
    }
}