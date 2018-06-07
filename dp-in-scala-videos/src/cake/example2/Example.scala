package cake.example2

/**
  * *
  * Uses the cake pattern in scala to perform dependency injection.
  *
  * In this example we build on example 1 providing A and B with different instances of C
  * which is itself dependent on configuration.
  *
  * ```
  * B -> Configuration
  * -> A
  * -> C
  * A -> Configuration
  * -> C (different instance)
  * C -> Configuration
  * ```
  */

import java.util.UUID._

import cake._

trait AComponent {
  this: ConfigurationComponent with CComponent =>
  val a: A

  class A {
    val c = new C()
    val value = "a-" + configuration.value + "-" + c.value
  }

}

trait BComponent {
  this: ConfigurationComponent with AComponent with CComponent =>
  val b: B

  class B {
    val c = new C()
    val value = a.value + "-b-" + configuration.value + "-" + c.value
  }

}

trait CComponent {
  this: ConfigurationComponent =>

  class C {
    val value = "c-" + configuration.value + "-" +
      randomUUID.toString.substring(1, 5)
  }

}

trait Components
  extends ConfigurationComponent
    with AComponent
    with BComponent
    with CComponent

object Registry extends Components {
  val configuration = new DefaultConfiguration
  val a = new A()
  val b = new B()
}