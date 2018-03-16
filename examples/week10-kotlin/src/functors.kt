fun sumThree(n: Int) = n + 3

infix fun IntFunction.map(g: (Int) -> Int): (Int) -> Int {
    return { x -> this(g(x)) }
}

sealed class Option<out A> {
    object None : Option<Nothing>()
    data class Some<out A>(val value: A) : Option<A>()


    inline fun <B> map(f: (A) -> B): Option<B> = when (this) {
        is None -> this
        is Some -> Some(f(value))
    }
}

fun someCallThatMightReturnNone(): Option<Int> {
    return Option.None
}

fun main(args: Array<String>) {
    println(Option.Some(2).map(::sumThree))
    println(Option.Some(2).map { it + 3 })

    val foo = { a: Int -> a + 2 } map { a: Int -> a + 3 }
    println(foo(10))

    val option: Option<Int> = someCallThatMightReturnNone()
    println(option.map { it + 3 })
}