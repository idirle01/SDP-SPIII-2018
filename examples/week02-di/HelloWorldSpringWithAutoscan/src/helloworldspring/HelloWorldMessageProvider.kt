package helloworldspring

import org.springframework.stereotype.Component

@Component
class HelloWorldMessageProvider : MessageProvider {

    override val message: String
        get() = "Hello World! --- with Autoscan! How does that work?"

}