package com.example.pizzaapp;

/**
 * Template for customizing an object that implements it based on its instance.
 * @param <E> The datatype that is being customized; for example toppings being added to a list
 * @author Blake Bodajlo, Stanley Jiang
 */
public interface Customizable<E> {
    /**
     * Add an object
     * @param obj The object being added
     */
    boolean add(Object obj);
    /**
     * Remove an object
     * @param obj The object being removed
     */
    boolean remove(Object obj);
}