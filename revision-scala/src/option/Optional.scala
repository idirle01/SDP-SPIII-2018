sealed trait Option[+A]
case object None extends Option[Nothing]
case class Some[A](a: A) extends Option[A]

sealed trait Either[+A, +B]
case class Left[A](a: A) extends Either[A, Nothing]
case class Right[B](b: B) extends Either[Nothing, B]

object OptionalApp extends App {
  def safeDiv(a: Int, b: Int): Option[Int] =
    if (b != 0) Some(a / b) else None

  println(safeDiv(10, 2))
  println(safeDiv(10, 0))

  def safeDiv2(a: Int, b: Int): Either[String, Int] =
    if (b != 0) Right(a / b) else Left("Divide by zero!")

  println(safeDiv2(10, 2))
  println(safeDiv2(10, 0))
}