package extensions

fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] // 'this' corresponds to the list
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main(args: Array<String>) {
    val l = mutableListOf(1, 2, 3)
    println(l)
    l.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
    println(l)
    val lst = mutableListOf("abcd", "defg", "jklm")
    println(lst)
    lst.swap(0, 2) // 'this' inside 'swap()' will hold the value of 'l'
    println(lst)

}
