package com.example.pizzaapp;

import java.io.Serializable;


public class OrderItem implements Serializable {
    private Order orderString;

    /**
     * Parameterized constructor.
     * @param order
     */
    public OrderItem(Order order) {
        this.orderString = order;

    }
    /**
     * Getter method that returns the item name of an item.
     * @return the item name of an item.
     */
    public Order getItemName() {
        return orderString;
    }


}
