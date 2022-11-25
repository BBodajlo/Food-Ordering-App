package com.example.pizzaapp;

/**
 * Creates NYPizzas by using the PizzaFactory interface methods
 * Instantiates and creates pizza objects based on the method called
 * Each method determines the crust and the toppings and will return the pizza object created
 * @author Blake Bodajlo, Stanley Jiang
 */
public class NYPizza implements PizzaFactory{
    /**
     * Creates a deluxe pizza in the NYPizza style
     * The NYPizza style only alters the crust
     * The toppings are universal for the Deluxe pizza
     * @return A deluxe pizza object
     */
    @Override
    public Pizza createDeluxe() {
        Deluxe deluxePizza = new Deluxe(Crust.Brooklyn);
        deluxePizza.add(Topping.Sausage);
        deluxePizza.add(Topping.Pepperoni);
        deluxePizza.add(Topping.Green_pepper);
        deluxePizza.add(Topping.Onion);
        deluxePizza.add(Topping.Mushroom);
        return deluxePizza;
    }

    /**
     * Creates a Meatzza pizza in the NYPizza style
     * The NYPizza style only alters the crust
     * The toppings are universal for the Meatzza pizza
     * @return A Meatzza pizza object
     */
    @Override
    public Pizza createMeatzza() {
        Meatzza meatzzaPizza = new Meatzza(Crust.Hand_Tossed);
        meatzzaPizza.add(Topping.Sausage);
        meatzzaPizza.add(Topping.Pepperoni);
        meatzzaPizza.add(Topping.Beef);
        meatzzaPizza.add(Topping.Ham);
        return meatzzaPizza;
    }

    /**
     * Creates a BBQChicken pizza in the NYPizza style
     * The NYPizza style only alters the crust
     * The toppings are universal for the BBQChicken pizza
     * @return A BBQChicken pizza object
     */
    @Override
    public Pizza createBBQChicken() {
        BBQChicken bbqChickenPizza = new BBQChicken(Crust.Thin);
        bbqChickenPizza.add(Topping.BBQ_chicken);
        bbqChickenPizza.add(Topping.Green_pepper);
        bbqChickenPizza.add(Topping.Provolone);
        bbqChickenPizza.add(Topping.Cheddar);
        return bbqChickenPizza;
    }

    /**
     * Creates a BuildYourOwn pizza in the NYPizza style
     * The NYPizza style only alters the crust
     * Toppings are handled by the GUI Controller class
     * @return A BuildYourOwn pizza object
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.Hand_Tossed);
    }
}
