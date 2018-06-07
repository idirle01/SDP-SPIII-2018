package abstractfactory.restaurant;

import abstractfactory.restaurant.Appetizer;
import abstractfactory.restaurant.Dessert;
import abstractfactory.restaurant.Entree;

public interface Restaurant {
    public Appetizer getAppetizer();

    public Entree getEntree();

    public Dessert getDessert();
}