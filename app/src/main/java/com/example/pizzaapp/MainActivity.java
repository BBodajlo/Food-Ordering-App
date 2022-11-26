package com.example.pizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToChicago(View view){
        Intent intent = new Intent(this, ChicagoActivity.class);
        startActivity(intent);

    }
    public void goToOrder(View view)
    {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}