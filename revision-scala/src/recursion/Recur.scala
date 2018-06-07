package recursion

import scala.annotation.tailrec

object Recur extends App {
  val list = List.range(1, 100)

  println(sum(list))
  println(sum2(list))
  println(sum3(list))
  println(sum4(list))

  // (1) yields a "java.lang.StackOverflowError" with large lists
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case x :: tail => x + sum(tail)
  }

  // (2) recursion
  def sum2(xs: List[Int]): Int = {
    if (xs.isEmpty) 0
    else xs.head + sum3(xs.tail)
  }

  // (3) tail-recursive solution
  def sum3(ints: List[Int]): Int = {
    @tailrec
    def sumAccumulator(ints: List[Int], accum: Int): Int = {
      ints match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x)
      }
    }
    sumAccumulator(ints, 0)
  }
  // (4) using reduce
  def sum4(ints: List[Int]) = {
    ints.reduceLeft(_ + _)
  }

}