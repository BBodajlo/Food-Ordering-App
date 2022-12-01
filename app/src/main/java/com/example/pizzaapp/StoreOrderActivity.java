package com.example.pizzaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
/**
 * Creates the Store Order activity which stores any pizza that are going to be made into
 * confirmed orders. Users are allowed to remove stored orders. Orders will be displayed
 * in descending order, along with order information and final price. The count of stored
 * order will be remembered, regardless of removal.
 * @author Blake Bodajlo, Stanley Jiang
 */
public class StoreOrderActivity extends AppCompatActivity {
    private RecyclerView storeRecycler;
    public static StoreOrders orderList = new StoreOrders();
    private static ArrayList<OrderItem> orderItems = new ArrayList<>();
    private static StoreOrderAdapter adapter;
    private Button storeOrderClearButton;

    /**
     * Set the views and functionally of the page.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeorder);
        storeRecycler = findViewById(R.id.storeRecycler);
        adapter = new StoreOrderAdapter(this, orderItems);
        storeRecycler.setAdapter(adapter);
        storeRecycler.setLayoutManager(new LinearLayoutManager(this));
        storeOrderClearButton = findViewById(R.id.storeOrderClearButton);
    }
    /**
     * Invoked when the user clicks the Clear Order button.
     * Clear the view of the current orders, notifying the user with
     * a toast once it has been cleared.
     * @param view The recycler view.
     */
    public void clearOrders(View view)
    {
        if(!orderList.getOrderList().isEmpty()) {
            orderItems.clear();
            orderList.getOrderList().clear();
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(), "Stored Orders Cleared!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Store Orders are Empty!", Toast.LENGTH_SHORT).show();
        }

    }
    /**
     * Clear list of order and then add
     * the current order's to the list.
     */
    private static void setupOrderItems()
    {
        orderItems.clear();
        for(int i = 0; i < orderList.getOrderList().size(); i++)
        {
            orderItems.add(new OrderItem(orderList.getOrderList().get(i)));
        }
    }
    /**
     * Add order to stored order.
     * @param order The order.
     */
    public static void addOrder(Order order){
        orderList.add(order);
        //System.out.print(order.toString());
        setupOrderItems();
    }
    /**
     * Get the stored order.
     * @return The stored order.
     */
    public static StoreOrders getStoreOrder()
    {
        return orderList;
    }
    /**
     * Calls the SetupOrderItems method.
     */
    public static void updateList()
    {
        setupOrderItems();
    }
    /**
     * Get the store adapter.
     * @return The adapter
     */
    public static StoreOrderAdapter getStoreAdapter()
    {
        return adapter;
    }
    /**
     * Get the order list.
     * @return The order list.
     */
    public static StoreOrders getOrderList()
    {
        return orderList;
    }



}