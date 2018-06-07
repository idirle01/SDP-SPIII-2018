package cake.example1

import cake._

/**
  * *
  * Uses the cake pattern in scala to perform dependency injection.
  *
  * In this example B depends on Configuration and A and A depends
  * on Configuration.
  *
  */

trait AComponent {
  this: ConfigurationComponent =>
  val a: A

  class A {
    val value = "a-" + configuration.value
  }

}

trait BComponent {
  this: ConfigurationComponent with AComponent =>
  val b: B

  class B {
    val value = a.value + "-b-" + configuration.value
  }

}

trait Components
  extends ConfigurationComponent
    with AComponent
    with BComponent

object Registry extends Components {
  val configuration = new DefaultConfiguration
  val a = new A()
  val b = new B()
}

object RegistryTesting extends Components {
  val configuration = new TestingConfiguration
  val a = new A()
  val b = new B()
}