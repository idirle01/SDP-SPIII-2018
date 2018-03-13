import java.io.FileInputStream
import java.util.*

object MessageSupportFactory {
    val ROOT = System.getProperty("user.dir") + "/week-two-di" + "/HelloWorldDecoupledInterfaceWithFactory"

    private lateinit var props: Properties
    lateinit var messageRenderer: MessageRenderer
        private set
    lateinit var messageProvider: MessageProvider
        private set

    init {
        props = Properties()

        try {
            props.load(FileInputStream(ROOT + "/bean.properties"))

            // get the implementation classes
            val rendererClass = props.getProperty("renderer.class")
            val providerClass = props.getProperty("provider.class")

            messageRenderer = Class.forName(rendererClass).getConstructor().newInstance() as MessageRenderer
            messageProvider = Class.forName(providerClass).getConstructor().newInstance() as MessageProvider
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}