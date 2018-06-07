package algebraic

interface Tree
object Empty : Tree
data class Leaf(val value: Int) : Tree
data class Node(val left: Tree, val right: Tree) : Tree

fun max(x: Int, y: Int): Int = if (x > y) x else y

fun depth(t: Tree): Int = when (t) {
    is Empty -> 0
    is Leaf -> 1
    is Node -> 1 + max(depth(t.left), depth(t.right))
// unfortunately, the else branch is required
    else -> throw NoWhenBranchMatchedException()
}


fun main(args: Array<String>) {
    println(depth(
            Node(Node(Leaf(1), Leaf(2)), Leaf(3))
    ))
}