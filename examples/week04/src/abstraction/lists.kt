package abstraction

sealed class IntList
final object End : IntList()
final data class Node(val head: Int, val tail: IntList) : IntList()

fun length(l: IntList): Int = abstraction(0, l, { hd, tl -> 1 + tl})
fun product(l: IntList): Int = abstraction(1, l, {hd, tl  -> hd * tl})
fun sum(l: IntList): Int = abstraction(0, l,  {hd, tl -> hd + tl})

fun abstraction(end: Int, l: IntList, f: (Int, Int) -> Int): Int = when (l) {
    End -> end
    is Node -> f(l.head, abstraction(end, l.tail, f))
}

fun main(args: Array<String>) {
    val example = Node(1, Node(2, Node(3, End)))
    assert(length(example) == 3)
    assert(length(example.tail) == 2)
    assert(length(End) == 0)
    assert(product(example) == 6)
    assert(sum(example) == 6)

    // Lambda Expression Syntax
    val add = { x: Int, y: Int -> x + y }
    assert(add(3,4) == 7)

    
}

