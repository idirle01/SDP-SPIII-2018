package memoization

import kotlin.system.measureTimeMillis

fun fib(k: Int): Long = when (k) {
    0 -> 1
    1 -> 1
    else -> fib(k - 1) + fib(k - 2)
}

val map = mutableMapOf<Int, Long>()
fun memfib(k: Int): Long {
    return map.getOrPut(k) {
        when (k) {
            0 -> 1
            1 -> 1
            else -> memfib(k - 1) + memfib(k - 2)
        }
    }
}


fun main(args: Array<String>){
    val NUMBER = 50
    val time1 = measureTimeMillis { println(fib(NUMBER))}
    val time2 = measureTimeMillis { println(memfib(NUMBER))}
    println("Recursive: ${time1} and Memo: ${time2}")
}