import org.springframework.beans.factory.BeanFactory
import org.springframework.beans.factory.support.DefaultListableBeanFactory
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader
import java.io.FileInputStream
import java.util.*

object HelloWorldSpring {

    val ROOT = System.getProperty("user.dir") + "/week-two-di" + "/HelloWorldSpring"

    // get the bean factory - understanding DefaultListableBeanFactory is not really important.
    // It is just an Factory class example from Spring, and an old version at that.
    // create a definition reader
    // load the configuration options
    private val beanFactory: BeanFactory
        @Throws(Exception::class)
        get() {
            val factory = DefaultListableBeanFactory()
            val rdr = PropertiesBeanDefinitionReader(factory)
            val props = Properties()
            props.load(FileInputStream(ROOT + "/beans.properties"))

            rdr.registerBeanDefinitions(props)

            return factory
        }

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {

        // get the bean factory
        val factory = beanFactory

        val mr = factory.getBean("renderer") as MessageRenderer
        val mp = factory.getBean("provider") as MessageProvider

        mr.messageProvider = mp
        mr.render()
    }
}