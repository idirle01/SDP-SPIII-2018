typealias IntFunction = (Int) -> Int

fun cycle(f1: IntFunction, f2: IntFunction, f3: IntFunction): (Int) -> IntFunction =
        { n: Int ->
            { x: Int ->
                // var i = 0
                // while i < n do
                fun loop(i: Int, x: Int): Int =
                        if (i < n) {
                            val rem = i % 3
                            when (rem) {
                                0 -> loop(i + 1, f1(x))
                                1 -> loop(i + 1, f2(x))
                                else -> loop(i + 1, f3(x))
                            }
                        } else {
                            x
                        }

                loop(0, x)
            }
        }

fun add1(x: Int) = x + 1
fun times2(x: Int) = x * 2
fun add3(x: Int) = x + 3

fun main(args: Array<String>) {
//    println(cycle(::add1, ::times2, ::add3)(5))
    val myCycle = cycle(::add1, ::times2, ::add3)
    val id = myCycle(0)
    println(id(5))
    // prints 5

    val addOneThenDouble = myCycle(2)
    println(addOneThenDouble(1))
    // prints 4

    val doAllFunctions = myCycle(3)
    println(doAllFunctions(2))
    // prints 9

    val doMoreThanACycle = myCycle(4)
    println(doMoreThanACycle(2))
    // prints 10

    val doTwoCycles = myCycle(6)
    println(doTwoCycles(1))
    // prints 19

}

//
//                when (n) {
//                    1 -> f1(x)
//                    2 -> f2(f1(x))
//                    3 -> f3(f2(f1(x)))
//                    else -> x
//                }