package com.example.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Sets up the main page of the Pizza Application. Users are allowed
 * to select from four different image views and go to their prospective activities.
 * The pages available being Chicago styled pizza, New York styled Pizza, order,
 * and stored order.
 * @author Blake Bodajlo, Stanley Jiang
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Create the main activity view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Go the to the Chicago pizza activity upon clicking the image view.
     * @param view The image view
     */
    public void goToChicago(View view){
        Intent intent = new Intent(this, ChicagoActivity.class);
        startActivity(intent);

    }
    /**
     * Go the to the New York activity upon clicking the image view.
     * @param view The image view
     */
    public void goToNY(View view){
        Intent intent = new Intent(this, NYActivity.class);
        startActivity(intent);

    }
    /**
     * Go the to the order activity upon clicking the image view.
     * @param view The image view
     */
    public void goToOrder(View view)
    {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
    /**
     * Go the to the stored order activity upon clicking the image view.
     * @param view The image view
     */
    public void goToStoreOrder(View view)
    {
        Intent intent = new Intent(this, StoreOrderActivity.class);
        startActivity(intent);
    }
}