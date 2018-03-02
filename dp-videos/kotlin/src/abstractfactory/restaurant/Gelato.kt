package abstractfactory.restaurant

import abstractfactory.restaurant.Dessert

class Gelato : Dessert {
    override fun enjoy() {
        println("Enjoying ice cream")
    }
}