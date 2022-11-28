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

public class StoreOrderActivity extends AppCompatActivity {
    private RecyclerView storeRecycler;
    public static StoreOrders orderList = new StoreOrders();
    private static ArrayList<OrderItem> orderItems = new ArrayList<>();
    private static StoreOrderAdapter adapter;
    private Button storeOrderClearButton;

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

    private static void setupOrderItems()
    {
        orderItems.clear();
        for(int i = 0; i < orderList.getOrderList().size(); i++)
        {
            orderItems.add(new OrderItem(orderList.getOrderList().get(i)));
        }
    }
    public static void addOrder(Order order){
        orderList.add(order);
        //System.out.print(order.toString());
        setupOrderItems();
    }

    public static StoreOrders getStoreOrder()
    {
        return orderList;
    }
    public static void updateList()
    {
        setupOrderItems();
    }

    public static StoreOrderAdapter getStoreAdapter()
    {
        return adapter;
    }

    public static StoreOrders getOrderList()
    {
        return orderList;
    }



}