package basic

sealed class IntList
final object End : IntList()
final data class Node(val head: Int, val tail: IntList) : IntList()

fun length(l: IntList): Int = when (l) {
    End -> 0
    is Node -> 1 + length(l.tail)
}

fun double(l: IntList): IntList = when (l) {
    End -> End
    is Node -> Node(l.head * 2, double(l.tail))
}

fun product(l: IntList): Int = when (l) {
    End -> 1
    is Node -> l.head * product(l.tail)
}

fun sum(l: IntList): Int = when (l) {
    End -> 0
    is Node -> l.head + sum(l.tail)
}

fun main(args: Array<String>) {
    val example = Node(1, Node(2, Node(3, End)))
    assert(length(example) == 3)
    assert(length(example.tail) == 2)
    assert(length(End) == 0)
}

