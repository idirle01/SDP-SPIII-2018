package demo

// ----- FUNCTIONS -----

// Returns 2 values
fun nextTwo(num: Int): Pair<Int, Int> {
    return Pair(num + 1, num + 2)
}

// Receive variable number of parameters
fun getSum(vararg nums: Int): Int {
    var sum = 0

    // For each value in the array add it to sum
    nums.forEach { n -> sum += n }

    return sum
}

fun fact(x: Int): Int {
    tailrec fun factTail(y: Int, z: Int): Int {
        if (y == 0) return z
        else return factTail(y - 1, y * z)
    }
    return factTail(x, 1)
}

// Returns a custom function that multiplies values
// times the value passed to it
fun makeMathFunc(num1: Int): (Int) -> Int = { num2 -> num1 * num2 }

// Receives a list and a function to use on the list
fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int) {
    for (num in numList) {
        println("MathOnList : ${myFunc(num)}")
    }
}
