//typealias IntPredicate = (Int) -> Boolean

fun returnFunction(): (Int) -> Boolean = { it % 2 == 0}
// returns a function that determines whether its argument is even

fun main(args: Array<String>) {
    //val isEven = returnFunction()
    println(returnFunction()(14))
//    println(isEven)
//    println(isEven(4))
//    println(isEven(3))
}