package com.tekadept.demo

fun closureMaker(): () -> Unit {
    var num = 0
    return { println(num++)}

}

fun main(args: Array<String>){
    val myCounter1 = closureMaker()
    val myCounter2 = closureMaker()
    myCounter1()
    myCounter1()
    myCounter1()
    myCounter1()
    myCounter2()
    myCounter2()
    myCounter1()
}