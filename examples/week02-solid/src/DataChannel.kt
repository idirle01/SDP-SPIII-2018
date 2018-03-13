interface DataChannel {
    fun send(c: Char)

    fun receive(): Char
}