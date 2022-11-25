package com.example.pizzaapp;

import java.util.ArrayList;

/**
 * Subclass of Pizza which creates a template for a Deluxe pizza object
 * The toppings are filled out by the PizzaFactory class
 * This class initializes the instance variables inherited from pizza and creates a unique
 * price based on its instance
 * @author Blake Bodajlo, Stanley Jiang
 */
public class Deluxe extends Pizza
{

    /**
     * Constructor to initialize a Deluxe object's size, crust, and toppings instance variables
     * @param c Crust is determined by the PizzaFactory class making the pizza; the parameter
     *          represents how the pizza factory wants to make the pizza's crust
     */
    public Deluxe(Crust c)
    {
        super();
        this.initializeToppings();
        this.setCrust(c);
    }


    /**
     * Calculates the price of a Deluxe pizza which has preset prices based on its size only
     * @return Price of the pizza determined by its size
     */
    @Override
    public double price() {
        double finalPrice = 0;

        assert(this.getSize() != null);

        if(getSize() == Size.Small)
        {
            finalPrice = 14.99;
        }
        else if(getSize() == Size.Medium)
        {
            finalPrice = 16.99;
        }
        else if(getSize() == Size.Large)
        {
            finalPrice = 18.99;
        }

        return finalPrice;
    }
}
