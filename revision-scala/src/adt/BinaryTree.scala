package adt

// This is a full version of a binary tree class in Scala
// It is more detailed than anything that might occur in the exam.

/**
 * Defines a tree element has having a value and a
 * count to avoid duplicates in the tree
 */
case class Element(val value: Int) {
  override def toString = s"(${value})"
}

/**
 * A tree definition, support for add, delete,
 * search, size, height and pretty print
 */
sealed trait Tree {
  def add(b: Int): Tree
  def search(b: Int): Boolean
  def delete(b: Int): Tree
}

/**
 * Act a stopper for the tree branches
 */
object Empty extends Tree {
  def add(b: Int) = Node(Element(b), Empty, Empty)
  def search(b: Int) = false
  def delete(b: Int) = Empty
  override def toString = "E"
}

/**
 * Node class - includes several supporting functions for display purposes
 */
sealed case class Node(el: Element, left: Tree, right: Tree) extends Tree {

  /**
   * If value already exists then increment count value
   * If bigger then continue in the right subtree
   * else in the left subtree
   */
  def add(b: Int) = {
    if (b == el.value) Node(Element(el.value), left, right)
    else if (b > el.value) Node(el, left, right.add(b))
    else Node(el, left.add(b), right)
  }

  /**
   * Found if same value otherwise
   * if bigger, search in right subtree
   * else search in left subtree
   */
  def search(b: Int) = {
    if (b == el.value) true
    else if (b < el.value) left.search(b)
    else right.search(b)
  }

  /**
   * Pop the maximum element from the right subtree
   * and return the max value and the new subtree
   */
  def popMaximum: (Element, Tree) = right match {
    case Empty => (el, left)
    case nRight: Node =>
      val (max, t) = nRight.popMaximum
      (max, Node(el, left, t))
  }

  /**
   * If found and no sub trees, then just replace it by Empty
   * If only left or right subtree, then just replace it by the subtree
   * Else find maximum in the left subtree and replace the element `a` by
   * this maximum. The maximum is removed from the left subtree
   * Note that another implementation could be to decrement first the count if > 1
   */
  def delete(b: Int): Tree = {
    if (el.value == b) {
      left match {
        case Empty => right
        case _ if right == Empty => left
        case nLeft: Node =>
          val (max, newLeft) = nLeft.popMaximum
          Node(max, newLeft, right)
      }
    } else if (b < el.value) {
      Node(el, left.delete(b), right)
    } else {
      Node(el, left, right.delete(b))
    }
  }

}

object TreeApp extends App {

  def binaryTree(l: List[Int]) =
    l.foldLeft(Empty: Tree)((b, a) => b.add(a))

  val x = binaryTree(List(3, 1, 2, 11, 9))
  println(x)

  def isWellformed(t: Tree): Boolean = t match {
    case Empty => true
    case Node(el, left, right) => {
      val isLeftValid = left match {
        case Empty => true
        case Node(ell, _, _) => el.value > ell.value && isWellformed(left)
      }
      val isRightValid = right match {
        case Empty => true
        case Node(elr, _, _) => el.value < elr.value && isWellformed(right)
      }
      isLeftValid && isRightValid
    }
  }

  println(isWellformed(x))
}
