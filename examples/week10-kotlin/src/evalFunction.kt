typealias IntPredicate = (Int) -> Boolean
typealias IntIntFunction = (Int) -> Int

val adder1 = { x: Int -> x + 1}
val multiply2= { x: Int -> x * 2}

fun evalFunction(n: Int, pred: IntPredicate, f1: IntIntFunction, f2: IntIntFunction): IntIntFunction =
        if (pred(n)) f1 else f2

fun main(args: Array<String>){
    println(evalFunction(3, {x:Int -> x % 2 == 0}, adder1, multiply2)(12))
}