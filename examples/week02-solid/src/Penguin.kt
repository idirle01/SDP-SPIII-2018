class Penguin : Bird() {
    override fun fly() = throw UnsupportedOperationException()
}