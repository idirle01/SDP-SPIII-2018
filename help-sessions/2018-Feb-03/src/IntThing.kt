fun thing(): IntRange {
    return IntRange(1,20)
}


fun main(args: Array<String>){
    thing().forEach { println(it) }
}