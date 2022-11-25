package com.example.pizzaapp;

/**
 * Creates ChicagoPizzas by using the PizzaFactory interface methods
 * Instantiates and creates pizza objects based on the method called
 * Each method determines the crust and the toppings and will return the pizza object created
 * @author Blake Bodajlo, Stanley Jiang
 */
public class ChicagoPizza  implements PizzaFactory{

    /**
     * Creates a deluxe pizza in the ChicagoPizza style
     * The ChicagoPizza style only alters the crust
     * The toppings are universal for the Deluxe pizza
     * @return A deluxe pizza object
     */
    @Override
    public Pizza createDeluxe() {
        Deluxe deluxePizza = new Deluxe(Crust.Deep_Dish);
        deluxePizza.add(Topping.Sausage);
        deluxePizza.add(Topping.Pepperoni);
        deluxePizza.add(Topping.Green_pepper);
        deluxePizza.add(Topping.Onion);
        deluxePizza.add(Topping.Mushroom);
        return deluxePizza;
    }

    /**
     * Creates a Meatzza pizza in the ChicagoPizza style
     * The ChicagoPizza style only alters the crust
     * The toppings are universal for the Meatzza pizza
     * @return A Meatzza pizza object
     */
    @Override
    public Pizza createMeatzza() {
        Meatzza meatzzaPizza = new Meatzza(Crust.Stuffed);
        meatzzaPizza.add(Topping.Sausage);
        meatzzaPizza.add(Topping.Pepperoni);
        meatzzaPizza.add(Topping.Beef);
        meatzzaPizza.add(Topping.Ham);
        return meatzzaPizza;

    }

    /**
     * Creates a BBQChicken pizza in the ChicagoPizza style
     * The ChicagoPizza style only alters the crust
     * The toppings are universal for the BBQChicken pizza
     * @return A BBQChicken pizza object
     */
    @Override
    public Pizza createBBQChicken() {
        BBQChicken bbqChickenPizza = new BBQChicken(Crust.Pan);
        bbqChickenPizza.add(Topping.BBQ_chicken);
        bbqChickenPizza.add(Topping.Green_pepper);
        bbqChickenPizza.add(Topping.Provolone);
        bbqChickenPizza.add(Topping.Cheddar);
        return bbqChickenPizza;


    }

    /**
     * Creates a BuildYourOwn pizza in the ChicagoPizza style
     * The ChicagoPizza style only alters the crust
     * Toppings are handled by the GUI Controller class
     * @return A BuildYourOwn pizza object
     */
    @Override
    public Pizza createBuildYourOwn() {
        return new BuildYourOwn(Crust.Pan);
    }

    public static void main(String[] args)
    {
        PizzaFactory pizzaFactory = new ChicagoPizza();
        Pizza pizza = pizzaFactory.createDeluxe();
        Pizza pizza2 = pizzaFactory.createBBQChicken();
        PizzaFactory pizzaFactory1 = new NYPizza();
        Pizza byo = pizzaFactory1.createBuildYourOwn();
        byo.setSize(Size.Medium);
        byo.add(Topping.Pepperoni);
        StoreOrders orderL = new StoreOrders();
        pizza.setSize(Size.Large);
        pizza2.setSize(Size.Small);
        Order o  = new Order(orderL.getNextOrderNumber());
        o.add(pizza);
        o.add(pizza2);
        o.remove(pizza);
        orderL.add(o);
        Order o2 = new Order(orderL.getNextOrderNumber());
        o2.add(pizza);
        o2.add(byo);
        orderL.add(o2);
        Order o3 = new Order(orderL.getNextOrderNumber());
        o3.add(pizza);
        orderL.add(o3);
        System.out.println(orderL.toString());
        orderL.remove(o2);
        System.out.println(orderL.toString());

    }

}
