package com.tekadept.demo

import org.funktionale.collections.destructured
import org.funktionale.composition.compose
import org.funktionale.composition.forwardCompose
import org.funktionale.currying.*
import org.funktionale.partials.partially1
import org.funktionale.partials.partially3
import org.funktionale.memoization.memoize

fun functional() {
    val (head, tail) = listOf(1, 2, 3).destructured()
    println("Head = $head and tail = $tail")



    val add5 = {i: Int -> i + 5}
    val multiplyBy2 = {i: Int -> i * 2}

    val multiplyBy2andAdd5 = add5 compose multiplyBy2
    val composeResults = multiplyBy2andAdd5(10)
    println("multiplyBy2andAdd5(10) = $composeResults")

    val add5andMultiplyBy2 = add5 forwardCompose multiplyBy2
    val forwardComposeResults = add5andMultiplyBy2(10)
    println("add5andMultiplyBy2(10) = $forwardComposeResults")


    val sum3ints = {x: Int, y: Int, z: Int -> x + y + z}
    val curried: (Int) -> (Int) -> (Int) -> Int = sum3ints.curried()
    val cur = curried(2)(4)(6)
    println("curried(2)(4)(6) = $cur")



    val prefixAndPosfix: (String, String, String) -> String =
            {prefix: String, x: String, postfix: String -> "${prefix}${x}${postfix}"}
    val prefixAndBang: (String, String) -> String = prefixAndPosfix.partially3("!")
    val hello: (String) -> String = prefixAndBang.partially1("Hello, ")
    println(hello("Funktionale"))

}

fun memo() {
    var fibonacci: (Long) -> Long = {it }
    fibonacci = { n: Long ->
        if (n < 2) n else fibonacci(n - 1) + fibonacci(n - 2)
    }

    var m: (Long) -> Long = {it}
    m = { n: Long ->
        if (n < 2) n else m(n - 1) + m(n - 2)
    }.memoize()

    println("Calling fib: " + timeElapsed {fibonacci(40)} + " ms")
    println("Calling memoized version" + timeElapsed{ m(40)} +" ms")
}

fun timeElapsed(body: ()-> Unit): Long {
    val start = System.currentTimeMillis()
    body()
    val end = System.currentTimeMillis()
    return end - start
}


fun main(args: Array<String>){
    // functional()

    memo()
}