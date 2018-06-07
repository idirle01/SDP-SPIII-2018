sealed trait Tree[A]
case class Node[A](left: Tree[A], elem: A, right: Tree[A]) extends Tree[A]
object Leaf extends Tree[Nothing]
