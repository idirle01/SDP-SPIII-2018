package decorator

import java.text.DecimalFormat

fun main(args: Array<String>) {
    var pizza: Pizza = SimplyVegPizza()
    print(pizza)
    pizza = RomaTomatoes(pizza)
    print(pizza)
    pizza = GreenOlives(pizza)
    print(pizza)
    pizza = Spinach(pizza)
    print(pizza)
    pizza = SimplyNonVegPizza()
    print(pizza)
    pizza = Meat(pizza)
    print(pizza)
    pizza = Cheese(pizza)
    print(pizza)
    pizza = Ham(pizza)
    print(pizza)
}

fun printPizza(pizza: Pizza) {
    val dformat: DecimalFormat = DecimalFormat("#.##")
    println("Desc: ${pizza.description}")
    println("Price: ${dformat.format(pizza.price)}")
}
