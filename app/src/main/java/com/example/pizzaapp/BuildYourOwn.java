package com.example.pizzaapp;

/**
 * Subclass of Pizza which creates a template for a BuildYourOwn pizza object
 * The toppings are filled out by the PizzaFactory class and Controller class
 * This class initializes the instance variables inherited from pizza and creates a unique
 * price based on its instance
 * @author Blake Bodajlo, Stanley Jiang
 */
public class BuildYourOwn extends Pizza
{
    /**
     * Subclass of Pizza which creates a template for a BuildYourOwn pizza object
     * The toppings are filled out by the PizzaFactory class and Controller class
     * This class initializes the instance variables inherited from pizza and creates a unique
     * price based on its instance
     * @author Blake Bodajlo, Stanley Jiang
     */
    public BuildYourOwn(Crust c)
    {
        super();
        this.initializeToppings();
        this.setCrust(c);
    }


    /**
     * Calculates the price of a BuildYourOwn pizza which has preset prices based on its size and
     * the number of toppings added. Each topping added is 1.59 more to the final price
     * @return Price of the pizza determined by its size and toppings to only 2 decimals
     */
    @Override
    public double price() {
        double finalPrice = 0;

        double pricePerTopping = 1.59;


        if(getSize() == Size.Small)
        {
            finalPrice = 8.99 + (pricePerTopping*getToppings().size());
        }
        else if(getSize() == Size.Medium)
        {
            finalPrice = 10.99 + (pricePerTopping*getToppings().size());
        }
        else if(getSize() == Size.Large)
        {
            finalPrice = 12.99 + (pricePerTopping*getToppings().size());
        }

        String price = String.format("%.2f",finalPrice);
        finalPrice = Double.parseDouble(price);
        return finalPrice;
    }
}
