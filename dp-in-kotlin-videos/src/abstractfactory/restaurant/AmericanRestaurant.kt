package abstractfactory.restaurant

class AmericanRestaurant : Restaurant {
    override val appetizer: Appetizer
        get() = Oysters()

    override val entree: Entree
        get() = Steak()

    override val dessert: Dessert
        get() = CheeseCake()
}