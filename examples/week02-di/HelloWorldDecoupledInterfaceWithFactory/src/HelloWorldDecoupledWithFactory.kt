fun main(args: Array<String>) {
    val mr = MessageSupportFactory.messageRenderer
    val mp = MessageSupportFactory.messageProvider
    mr!!.messageProvider = mp
    mr.render()
}
