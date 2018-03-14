package iterator

class ShapeStorage {
  val NUMBER_OF_SHAPES = 5

  var shapes = new Array[Shape](NUMBER_OF_SHAPES)

  private var index: Int = 0

  def addShape(name: String): Unit = {
    shapes(index) = new Shape(index, name)
    index += 1
  }
}
