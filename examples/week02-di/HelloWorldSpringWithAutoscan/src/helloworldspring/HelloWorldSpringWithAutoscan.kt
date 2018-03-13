package helloworldspring

import org.springframework.beans.factory.BeanFactory
import org.springframework.context.support.ClassPathXmlApplicationContext

object HelloWorldSpringWithAutoscan {
    val ROOT = System.getProperty("user.dir") + "/week-two-di" + "/HelloWorldSpringWithAutoscan"

    private val beanFactory: BeanFactory
        @Throws(Exception::class)
        get() = ClassPathXmlApplicationContext("file:" + ROOT + "/beans.xml")

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {

        // get the bean factory
        val factory = beanFactory
        val mr = factory.getBean("renderer") as MessageRenderer
        mr.render()
    }
}
