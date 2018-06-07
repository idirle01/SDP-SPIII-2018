package misc

import kotlin.system.measureTimeMillis


fun <T> merge(lstA: List<T>, lstB: List<T>, cmp: (T, T) -> Boolean): List<T> = when {
    lstA.isEmpty() -> lstB
    lstB.isEmpty() -> lstA
    else -> {
        val a = lstA.first()
        val b = lstB.first()
        if (cmp(a, b))
            listOf(a) + merge(lstA.drop(1), lstB, cmp)
        else
            listOf(b) + merge(lstA, lstB.drop(1), cmp)
    }

}


fun <T> merge2(lstA: List<T>, lstB: List<T>, cmp: (T, T) -> Boolean): List<T> {
    tailrec fun loop(tmpAs: List<T>, tmpBs: List<T>, tmpRes: List<T>): List<T> = when {
        tmpAs.isEmpty() -> tmpRes.reversed() + tmpBs
        tmpBs.isEmpty() -> tmpRes.reversed() + tmpAs
        else -> {
            val a = tmpAs.first()
            val b = tmpBs.first()
            if (cmp(a, b))
                loop(tmpAs.drop(1), tmpBs, listOf(a) + tmpRes)
            else
                loop(tmpAs, tmpBs.drop(1), listOf(b) + tmpRes)
        }
    }
    return loop(lstA, lstB, listOf())
}

fun main(args: Array<String>) {
    val time1 = measureTimeMillis {
        println(merge(listOf(1, 4, 7, 10, 11), listOf(2, 3, 5, 7, 12, 16), { x, y -> x <= y }))
    }
    val time2 = measureTimeMillis {
        println(merge2(listOf(1, 4, 7, 10, 11), listOf(2, 3, 5, 7, 12, 16), { x, y -> x <= y }))
    }
    println("Time for recursion: $time1; Time for tail recursion: $time2")

    // listOf(1, 2, 3, 4, 5, 7, 7, 10, 11, 12, 16)
}