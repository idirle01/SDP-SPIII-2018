// Sum types in Scala

// encoded via subclassing

sealed trait Pet
case class Cat(name: String) extends Pet
case class Fish(name: String, colour: String) extends Pet
case class Squid(name: String, age: Int) extends Pet

object SumApp extends App {
  val bob: Pet = Cat("Bob")
  println(bob)

  // destructured using pattern matching

  def sayHi(p: Pet): String =
    p match {
      case Cat(n) => "Meow " + n + "!"
      case Fish(n, _) => "Hello fishy " + n + "."
      case Squid(n, _) => "Hi " + n + "."
    }

  println(sayHi(bob))
  println(sayHi(Squid("Steve", 10)))
}
