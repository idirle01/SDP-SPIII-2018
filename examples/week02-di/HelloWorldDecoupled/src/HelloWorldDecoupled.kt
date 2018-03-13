fun main(args: Array<String>) {
    val mr = StandardOutMessageRenderer()
    val mp = HelloWorldMessageProvider()
    mr.messageProvider = mp
    mr.render()
}