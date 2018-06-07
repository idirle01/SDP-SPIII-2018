package abstractfactory.car

import abstractfactory.car.BMWFactory
import abstractfactory.car.Car
import abstractfactory.car.FordFactory

fun main(args: Array<String>) {
    val fordcar = Car(FordFactory())
    println(fordcar)

    val bmwcar = Car(BMWFactory())
    println(bmwcar)
}
