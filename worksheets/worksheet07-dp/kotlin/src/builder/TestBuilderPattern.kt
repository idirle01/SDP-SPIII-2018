package builder

fun main(args: Array<String>) {
    var carBuilder: CarBuilder = SedanCarBuilder
    var director: CarDirector = CarDirector(carBuilder)

    director.build()
    println(carBuilder.getCar())

    carBuilder = SportsCarBuilder
    director = CarDirector(carBuilder)

    director.build()
    println(carBuilder.getCar())
}
