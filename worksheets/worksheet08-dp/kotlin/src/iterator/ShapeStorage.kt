package iterator

class ShapeStorage {
    val NUMBER_OF_SHAPES = 5

    val shapes = arrayOfNulls<Shape>(NUMBER_OF_SHAPES)

    private var index: Int = 0

    fun addShape(name: String) {
        shapes[index] = Shape(index, name)
        index += 1
    }
}
