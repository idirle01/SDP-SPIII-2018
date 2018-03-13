interface Modem {
    fun dial(pno: String)

    fun hangup()

    fun send(c: Char)

    fun receive(): Char
}