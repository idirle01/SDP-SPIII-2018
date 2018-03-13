package reflection

import java.util.*
import kotlin.reflect.full.allSuperclasses
import kotlin.reflect.full.declaredFunctions


fun main(args: Array<String>) {
    // Get Class using reflection
    val concreteClass = ConcreteClass::class

    println(concreteClass.qualifiedName)
    println(concreteClass.typeParameters)

    val booleanClass = Boolean::class
    println(booleanClass.qualifiedName)

    val cDouble = Double::class
    println(cDouble.qualifiedName)

    val cDoubleArray = Class.forName("[D")
    println(cDoubleArray.canonicalName)

    val twoDStringArray = Array<Array<String>>::class
    println(twoDStringArray.qualifiedName)

    val superClass: Class<*> = Class.forName("reflection.BaseClass").superclass
    println(superClass);
    println(Object::class.supertypes)

    println(concreteClass.allSuperclasses)
    concreteClass.nestedClasses.forEach { println(it) }
    println(concreteClass.declaredFunctions)

    val typeParameters = Class.forName("java.util.HashMap").typeParameters
    typeParameters.forEach { print(it.name + ".") }
    println()

    val privateField = Class.forName("reflection.ConcreteClass").getDeclaredField("privateString")
    //turning off access check with below method call
    privateField.isAccessible = true
    val objTest = ConcreteClass(1)
    println(privateField.get(objTest))
    privateField.set(objTest, "private string updated")
    println(privateField.get(objTest))

    val method = Class.forName("java.util.Map").getMethod("put", Any::class.java, Any::class.java)
    val hm = HashMap<String, String>()
    println(hm)
    method.invoke(hm, "key", "value")
    println(hm)
}