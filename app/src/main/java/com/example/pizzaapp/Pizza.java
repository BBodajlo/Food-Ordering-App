package com.example.pizzaapp;

import java.util.ArrayList;

/**
 * Super class for all pizza object containing an abstract price method
 * Has fields for toppings, crust type, and size
 * Able to add and remove toppings from a pizza
 * Able to set crust and set size
 * @author Blake Bodajlo, Stanley Jiang
 */
public abstract class Pizza implements Customizable<Topping> {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;

    /**
     * Signature for the price method for implementation of the subclasses
     * @return Double representing the price of a pizza
     */
    public abstract double price();

    /**
     * Adds toppings to a pizza from the toppings enum
     * @param obj Topping from the topping enum
     * @return True if topping was added. False is topping was not added
     */
    @Override
    public boolean add(Object obj) {
        Topping toppingToAdd = (Topping)obj;
        if(toppingToAdd != null && !toppings.contains(toppingToAdd))
        {
            toppings.add(toppingToAdd);
            return true;
        }
        return false;
    }

    /**
     * Removes topping from a pizza
     * @param obj Topping from the enum class
     * @return True if topping was removed. False if topping was not removed
     */
    @Override
    public boolean remove(Object obj) {
        Topping toppingToRemove = (Topping)obj;
        if(toppingToRemove != null && toppings.contains(toppingToRemove))
        {
            toppings.remove(toppingToRemove);
            return true;
        }
        return false;
    }

    public String toString()
    {
        String pizza = "";
        pizza+= String.format("%s: %s, %s,",this.getClass().getSimpleName(),
                this.getCrust(),
                this.getSize());
        if(!this.getToppings().isEmpty()) {
            pizza += " Toppings: ";
            for (Topping t : this.getToppings()) {
                pizza += t + ", ";
            }
        }
        else {
            pizza+=" No Toppings, ";
        }
        pizza += "Price: " + this.price() + "\n";

        return pizza;
    }

    /**
     * Sets the crust of the current pizza.
     * Used by PizzaFactory when creating a pizza type
     * @param obj Crust value from the crust enum
     * @return True is crust was set. False if crust was not set.
     */
    public boolean setCrust(Object obj)
    {
        Crust crustToSet = (Crust)obj;
        if(crustToSet != null)
        {
            crust = crustToSet;
            return true;
        }
        return false;
    }
    /**
     * Sets the size of the current pizza.
     * Used by GUI Controller when creating a pizza type
     * @param obj Size value from the size enum
     * @return True is size was set. False if size was not set.
     */
    public boolean setSize(Object obj)
    {
        Size sizeToSet = (Size)obj;
        if(sizeToSet != null)
        {
            size = sizeToSet;
            return true;
        }
        return false;
    }

    /**
     * @return Size of the pizza (Large, Medium, Small)
     */
    public Size getSize()
    {
        return size;
    }

    /**
     *
     * @return The list of toppings of topping enum
     */
    public ArrayList<Topping> getToppings()
    {
        return toppings;
    }

    /**
     *
     * @return Crust of the pizza of crust enum
     */
    public Crust getCrust() {
        return crust;
    }


    /**
     * Used to initialize the topping list in the subclasses
     * The topping list cannot be null so a topping list should always be created
     * even if empty
     */
    public void initializeToppings()
    {
        toppings = new ArrayList<>();
    }

}

