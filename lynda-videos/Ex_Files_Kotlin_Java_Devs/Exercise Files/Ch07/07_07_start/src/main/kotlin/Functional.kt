package com.tekadept.demo

import org.funktionale.collections.destructured
import org.funktionale.composition.compose
import org.funktionale.composition.forwardCompose

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


}


fun main(args: Array<String>){
    functional()
}