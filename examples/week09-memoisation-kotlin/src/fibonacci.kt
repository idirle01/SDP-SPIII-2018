// produce recursive
fun fibRec(n: Int): Int = if (n <= 2) 1 else fibRec(n - 1) + fibRec(n - 2)

fun fibRecRet(n: Int): Int {
    if (n <= 2) {
        return 1
    } else {
        return fibRecRet(n-1) + fibRecRet(n-2)
    }
}

fun fibRecTail(n: Int): Int {
    fun helper(value:Int, current: Int, runningTotal:Int): Int {
        if (value <=2){
            return current
        } else {
            return helper(n-1, runningTotal,current + runningTotal)
        }
    }

    return helper(n,0, 1)
}

fun main(args: Array<String>) {
//    println(fib(10))
}

