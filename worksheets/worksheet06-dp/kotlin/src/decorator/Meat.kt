package decorator

class Meat(val pizza: Pizza) : Pizza {
    override val description: String
        get() = TODO("not implemented")
    override val price: Double
        get() = TODO("not implemented")
}
