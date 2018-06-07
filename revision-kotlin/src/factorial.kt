package a

import java.math.BigInteger


fun main(args: Array<String>) {
    val factorials: List<Long> = listOf(2, 5, 7, 8, 10, 11, 14, 16)

    for (num in factorials)
        println("factorial for $num is ${factor(num)}")
}

fun factor(num: Long): Long =
        when (num) {
            0L -> 1L
            else -> num * factor(num - 1L)
        }
