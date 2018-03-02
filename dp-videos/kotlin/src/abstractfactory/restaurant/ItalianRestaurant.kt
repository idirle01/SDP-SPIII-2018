package abstractfactory.restaurant

class ItalianRestaurant : Restaurant {
    override val appetizer: Appetizer
        get() = Pizzette()

    override val entree: Entree
        get() = Pasta()

    override val dessert: Dessert
        get() = Gelato()
}