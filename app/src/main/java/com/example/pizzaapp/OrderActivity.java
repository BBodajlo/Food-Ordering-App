package com.example.pizzaapp;

import android.hardware.camera2.params.Capability;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
/**
 * Creates the Order activity which stores any pizza that are going to be officially
 * placed as an order. The activity allows the user to remove pizza individually or clear
 * the order entirely. A pizza style, toppings, size, and price will be displaced. User can
 * place the order once it is confirmed.
 * @author Blake Bodajlo, Stanley Jiang
 */
public class OrderActivity extends AppCompatActivity {

    public static Order currentOrder = new Order(StoreOrderActivity.getOrderList().getNextOrderNumber());
    private RecyclerView orderRecycler;
    private static ArrayList<PizzaItem> pizzaItems = new ArrayList<>();
    private static OrderAdapter adapter;
    private Button clearButton;

    /**
     * Set the views and functionally of the page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //currentOrder = new Order(1);
        orderRecycler = findViewById(R.id.orderRecycler);
        adapter = new OrderAdapter(this, pizzaItems);
        clearButton = findViewById(R.id.clearButton);
       /* PizzaFactory p = new NYPizza();
        Pizza p1 = p.createBBQChicken();
        p1.setCrust(Crust.Brooklyn);
        p1.setSize(Size.Small);
        Pizza p2 = p.createBBQChicken();
        p2.setCrust(Crust.Brooklyn);
        p2.setSize(Size.Small);
        currentOrder.add(p1);
        currentOrder.add(p2);*/
        setupPizzaItems();
        orderRecycler.setAdapter(adapter);
        orderRecycler.setLayoutManager(new LinearLayoutManager(this));

    }

    /**
     * Clear list of pizzas and then add
     * the current order's pizza to the list.
     */
    private static void setupPizzaItems()
    {
        pizzaItems.clear();
        for(int i = 0; i < currentOrder.getPizzaList().size(); i++)
        {
                pizzaItems.add(new PizzaItem(currentOrder.getPizzaList().get(i)));

        }
    }

    /**
     * Add a pizza into the pizza list.
     */
    public static void addOrder(Pizza pizza){
        currentOrder.add(pizza);
        updateList();
    }

    /**
     * Get the current Order.
     * @return The current order.
     */
    public static Order getCurrentOrder()
    {
        return currentOrder;
    }

    /**
     * Calls the SetupPizzaItems method.
     */
    public static void updateList()
    {
        setupPizzaItems();
    }

    /**
     * Invoked when the user clicks the Clear Order button.
     * Clear the view of the current orders, notifying the user with
     * a toast once it has been cleared.
     * @param view The recycler view.
     */
    public void clearOrder(View view)
    {
        if(!currentOrder.isEmpty()) {
            pizzaItems.clear();
            currentOrder.getPizzaList().clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Order Cleared!", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Order is Empty!", Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * Invoked when the user clicks on the Place Order button.
     * Place the order in the view, notifying the user with
     * a toast once it has been cleared.
     * @param view The recycler view.
     */
    public void placeOrder(View view)
    {
        if(!currentOrder.isEmpty()) {
            StoreOrderActivity.addOrder(currentOrder);
            currentOrder = new Order(StoreOrderActivity.getOrderList().getNextOrderNumber());
            pizzaItems.clear();
            currentOrder.getPizzaList().clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Order placed!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Order is Empty!", Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * Get the order adapter.
     * @return the adapter.
     */
    public static OrderAdapter getOrderAdapater()
    {
        return adapter;
    }

}