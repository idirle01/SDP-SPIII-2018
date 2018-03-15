typealias IntFunc = (Int) -> Int

fun frightening(f1: IntFunc, f2: IntFunc, f3: IntFunc): (Int) -> IntFunc =
        { n: Int ->
            { x: Int ->
                fun loop(i: Int, value: Int): Int =
                        if (i < n) {
                            val rem = i % 3
                            when (rem) {
                                0 -> loop(i + 1, f1(value))
                                1 -> loop(i + 1, f2(value))
                                else -> loop(i + 1, f3(value))
                            }
                        } else {
                            value
                        }
                loop(0, x)
                // if n == 0 x
                // if n == 1 f1(x)
                // if n == 2 f2(f1(x))
                // if n == 3 f3(f2(f1(x)))
            }
        }

fun add1(x: Int) = x + 1
fun times2(x: Int) = x * 2
fun add3(x: Int) = x + 3

fun main(args: Array<String>) {
    val freddie = frightening(::add1, ::times2, ::add3)
//    println(freddie)
//    println(freddie(0))
//    println(freddie(0)(5))
    val id = freddie(0)
    println(id(5))
    // prints 5

    val addOneThenDouble = freddie(2)
    println(addOneThenDouble(1))
    // prints 4

    val doAllFunctions = freddie(3)
    println(doAllFunctions(2))
    // prints 9

    val doMoreThanCycle = freddie(4)
    println(doMoreThanCycle(2))
    // print 10

    val doTwoCycles = freddie(6)
    println(doTwoCycles(1))
    // print 19  f3(f2(f1(f3(f2(f1(x]
}

//when (n) {
//    1 -> f1(x)
//    2 -> f2(f1(x))
//    3 -> f3(f2(f1(x)))
//    else -> x
//}
