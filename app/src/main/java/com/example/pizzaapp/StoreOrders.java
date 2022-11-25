package com.example.pizzaapp;

import java.util.ArrayList;

/**
 * A database-like class for storing orders after they are created
 * Stores different order objects
 * Handles the order numbers
 * Able to add and remove orders
 * @author Blake Bodajlo, Stanley Jiang
 */
public class StoreOrders implements Customizable{

    private int nextOrderNumber;

    private ArrayList<Order> orderList;

    private String orderListMessage;

    /**
     * Default constructor for the StoreOrders class
     * Initializes the orderList and order number for the next order
     */
    public StoreOrders()
    {
        orderList = new ArrayList<Order>();
        nextOrderNumber = 1;
    }

    /**
     * Creates a string for the contents of the whole order database
     * Will go through each order stored and append their contents to the message
     * @return String containing a representation of the StoreOrders list
     */
    @Override
    public String toString()
    {
        orderListMessage = "";
        for(Order o : orderList)
        {
            //orderListMessage += "Order #" + o.getOrderNumber() + "\n";
            orderListMessage += o.toString();
        }
        return orderListMessage;
    }

    /**
     * Gives the number for the next order
     * Mainly used by the Order class when creating a new order
     * @return Integer for the next order number to be stored
     */
    public int getNextOrderNumber() {
        return nextOrderNumber;
    }

    /**
     * Adds an Order object to the order database
     * @param obj Order object
     * @return True if order was added. False if order was not added.
     */
    @Override
    public boolean add(Object obj) {
        Order orderToAdd = (Order)obj;

        if(orderToAdd != null)
        {
            orderList.add(orderToAdd);
            nextOrderNumber++;
            return true;
        }

        return false;
    }

    /**
     * Removes an order from the order database.
     * Also handles renumbering the order already in the StoreOrder list as well as
     * reimplementing the next order number
     * @param obj Order object
     * @return True if order was removed. False is order was not removed.
     */
    @Override
    public boolean remove(Object obj) {
        Order orderToRemove = (Order)obj;
        int index = 0;
        if(orderToRemove != null && orderList.contains(orderToRemove))
        {
            index = orderList.indexOf(orderToRemove);
            orderList.remove(orderToRemove);
            nextOrderNumber--;
            changeOrderNumber(index);
            return true;
        }
        return false;

    }

    /** MIGHT NEED FIXING;
     * Handles reordering the numbers in the current list
     */
    private void changeOrderNumber(int index) {
        for(int i = index; i < orderList.size(); i++)
        {
            orderList.get(i).setOrderNumber(orderList.get(i).getOrderNumber()-1);
        }
    }

    /**
     * Get the order list
     * @return The list
     */
    public ArrayList<Order> getOrderList(){
        return orderList;
    }
}
