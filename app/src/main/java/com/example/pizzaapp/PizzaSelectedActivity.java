package com.example.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

/**
 * For demonstration purpose, this class is the Activity to be started when an item on the
 * RecyclerView was clicked
 * Get the name of the item from an intent extra. The text of the button is set to the item name.
 * @author Lily Chang
 */
public class PizzaSelectedActivity extends AppCompatActivity {
    private Button btn_itemName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        btn_itemName.setText(intent.getStringExtra("ITEM"));
    }
}