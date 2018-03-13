package helloworldspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component("renderer")   // This is the same as @Component(value="renderer")
class StandardOutMessageRenderer : MessageRenderer {

    @Autowired
    private val messageProvider: MessageProvider? = null

    override fun render() {
        if (messageProvider == null) {
            throw RuntimeException(
                    "You must set the property messageProvider of class:" + StandardOutMessageRenderer::class.java.getName())
        }

        println(messageProvider.message)
    }
}