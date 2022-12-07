package com.example.pizzaapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Template for creating different types of pizza.
 * @author Blake Bodajlo, Stanley Jiang
 */
public interface PizzaFactory {
    /**
     * Create deluxe style
     */
    Pizza createDeluxe();

    /**
     * Create Meatzza style
     */
    Pizza createMeatzza();

    /**
     * Create BBQChicken style
     */
    Pizza createBBQChicken();

    /**
     * Create build your own style
     */
    Pizza createBuildYourOwn();
}
