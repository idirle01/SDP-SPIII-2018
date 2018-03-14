package iterator

data class ShapeIterator(private var shapes: Array<Shape?>) : MutableIterator<Shape?> {
    override fun remove() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasNext(): Boolean {
        TODO("not implemented")
    }

    override fun next(): Shape? {
        TODO("not implemented")
    }
}
