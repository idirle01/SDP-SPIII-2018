package hof

fun <A, B, C> compose(fn1: (A) -> B, fn2: (B) -> C): (A) -> C = { a ->
    val b = fn1(a)
    val c = fn2(b)
    c
}

fun main(args: Array<String>) {
    val f = String::length
    val g = Any::hashCode
    val fog = compose(f, g)

    println(fog("what is the hash of my length?"))
}