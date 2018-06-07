/*
 * You want to use a collection that works like a List but invokes its transformer methods (map, filter, etc.) lazily.
 */

object StreamApp extends App {

  def squares(x: Int): Stream[Int] = {
    (x * x) #:: squares(x + 1)
  }

  def sumSquares(x: Int): Int = {
    Stream.from(1) take x map ( y => y * y ) reduce (_ + _)
  }

  println("sum of squares to 10: " + sumSquares(10))

  println()

  squares(1) take 5 foreach println

  println()

  squares(10) take 5 foreach println

  println()
  
  println(Stream.from(1) take 10 reduce (_ + _))

}