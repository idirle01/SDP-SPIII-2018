package  com.tekadept.demo

fun sequences() {
    val students = getStudents()
    val sqStudents = students.drop(1).take(3).toList()
    println("Sequenced Students: "+ sqStudents)

    val numbers = generateSequence(100) { it + 1  }
    println("Numbers: "+numbers.drop(5).take(20).toList())

    val squares = generateSequence(1) {it+1}.map{it * it}
    val evenSquares = squares.filter{it % 2 == 0}
    println("Even Squares: "+evenSquares.take(5).toList())

    val fib = generateSequence(1 to 1) {it.second to it.first + it.second  }.
            map{it.first}
    println("Fibonacci: "+fib.take(15).toList())
}

fun main(args: Array<String>){
    sequences()
}