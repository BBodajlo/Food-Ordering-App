package com.example.pizzaapp;

import java.io.Serializable;


public class PizzaItem implements Serializable {
    private Pizza pizzaString;

    /**
     * Parameterized constructor.
     * @param pizza
     */
    public PizzaItem(Pizza pizza) {
        this.pizzaString = pizza;

    }
    /**
     * Getter method that returns the item name of an item.
     * @return the item name of an item.
     */
    public Pizza getItemName() {
        return pizzaString;
    }


}
