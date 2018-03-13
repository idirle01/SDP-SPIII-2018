typealias IntFunction = (Int) -> Int

fun cycle(f1: IntFunction, f2: IntFunction, f3: IntFunction): IntFunction {
    return { x -> f1(x)}
}

fun add1(x: Int) = x + 1
fun times2(x : Int) = x * 2
fun add3(x: Int) = x + 3

fun main(args: Array<String>){
//    println(cycle(::add1, ::times2, ::add3)(5))
    val myCycle = cycle(::add1,::times2,::add3)
    val id = myCycle(0)
    print(id(5))
    // prints 5

    val addOneThenDouble = myCycle(2)
    print(addOneThenDouble(1))
    // prints 4

    val doAllFunctions = myCycle(3)
    print(doAllFunctions(2))
    // prints 9
}

/*

 */