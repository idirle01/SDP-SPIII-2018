package abstractfactory.restaurant

import abstractfactory.restaurant.Appetizer
import abstractfactory.restaurant.Dessert
import abstractfactory.restaurant.Entree

interface Restaurant {
    val appetizer: Appetizer

    val entree: Entree

    val dessert: Dessert
}