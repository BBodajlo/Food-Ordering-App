package com.example.pizzaapp;

/**
 * Template for creating different types of pizza.
 * @author Blake Bodajlo, Stanley Jiang
 */
public interface PizzaFactory {
    /**
     * Create deluxe style
     */
    Pizza createDeluxe();
    /**
     * Create Meatzza style
     */
    Pizza createMeatzza();
    /**
     * Create BBQChicken style
     */
    Pizza createBBQChicken();
    /**
     * Create build your own style
     */
    Pizza createBuildYourOwn();
}