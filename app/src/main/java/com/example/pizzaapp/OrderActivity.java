package com.example.pizzaapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    public static Order currentOrder = new Order(1);
    private RecyclerView orderRecycler;
    private static ArrayList<PizzaItem> pizzaItems = new ArrayList<>();
    private static OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        currentOrder = new Order(1);
        orderRecycler = findViewById(R.id.orderRecycler);
        adapter = new OrderAdapter(this, pizzaItems);
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






    private static void setupPizzaItems()
    {
        for(int i = 0; i < currentOrder.getPizzaList().size(); i++)
        {
            pizzaItems.add(new PizzaItem(currentOrder.getPizzaList().get(i)));
        }
    }
    public static void addOrder(Pizza pizza){
        currentOrder.add(pizza);
        updateList();
    }
    public static void updateList()
    {
        setupPizzaItems();
    }

}