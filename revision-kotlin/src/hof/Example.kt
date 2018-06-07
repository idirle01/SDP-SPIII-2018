package hof

// Excerpt From: “Programming Kotlin”

fun foo(str: String, fn: (String) -> String): Unit {
    val applied = fn(str)
    println(applied)
}

fun bar(): (String) -> String = { str -> str.reversed() }

fun main(args: Array<String>) {
    foo("Hello", { it.reversed() })

    val ints = listOf(1, 2, 3, 4, 5, 6)
    val odds = ints.filter { it % 2 == 1 }
    val evens = ints.filter { it % 2 == 0 }

    println(odds)
    println(evens)

    val reversi = bar()
    println(reversi("hello"))
    println(reversi("world"))
}
