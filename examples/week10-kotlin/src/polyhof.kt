fun <A> findFirst(lst: List<A>, pred: (A) -> Boolean): Int {
    fun loop(n: Int): Int =
            if (n >= lst.size) -1 else if (pred(lst[n])) n else loop(n + 1)

//    fun loop(lst: List<A>): Int =
//        if (lst.isEmpty()) -1 else if (pred(lst[0])) else loop(lst.drop(1))
//
    return loop(0)
}

fun main(args: Array<String>) {
    val lst = listOf(1, 2, 3, 4, 5, 6, 7, 8)
//    val (x,y) = Pair(1,2)
//    println(x)
//    println(y)
//    print(lst.drop(1))

//    println(findFirst(lst, {it == 6}))
//    println(findFirst(lst, {it == 13}))
//    println(findFirst(lst, {it / 4 == 2}))
}