package iterator

fun main(args: Array<String>) {
    val storage = ShapeStorage()
    storage.addShape("Polygon")
    storage.addShape("Hexagon")
    storage.addShape("Circle")
    storage.addShape("Rectangle")
    storage.addShape("Square")

    var iterator = ShapeIterator(storage.shapes)

    while (iterator.hasNext()) {
        println(iterator.next())
    }

    println("Apply removing while iterating...")
    iterator = ShapeIterator(storage.shapes)

    while (iterator.hasNext()) {
        println(iterator.next())
        iterator.remove()
    }
}
