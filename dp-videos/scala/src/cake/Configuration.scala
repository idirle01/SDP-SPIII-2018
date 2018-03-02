package cake

trait Configuration {
  def value: String
}

class DefaultConfiguration extends Configuration {
  val value = "production"
}

class TestingConfiguration extends Configuration {
  val value = "test"
}

trait ConfigurationComponent {
  val configuration: Configuration
}

/*
 * To apply the cake pattern:
 *
 * wrap Configuration, A and B with their own traits (Component traits)
 * move constructor dependencies to Components using self types
 * add an abstract instance to each Component trait
 * create a Registry object that instantiates everything
 */
