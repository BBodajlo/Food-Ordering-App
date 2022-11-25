package com.example.pizzaapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.EventListener;

public class ChicagoActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{
    private Spinner chicagoSpinner;
    private TextView chicagoCrustText;
    private TextView chicagoSizeText;
    private PizzaFactory chicagoPizza = new ChicagoPizza();
    private Pizza currentPizza;
    private ArrayAdapter<PizzaType> pizzaType;
    private RadioGroup sizeGroup;
    private RadioButton smallSize;
    private RadioButton mediumSize;
    private RadioButton largeSize;
    private TextView priceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago);
        currentPizza = chicagoPizza.createDeluxe();
        currentPizza.setSize(Size.Small);
        Spinner chicagoSpinner = findViewById(R.id.chicagoSpinner);
        pizzaType = new ArrayAdapter<PizzaType>(this, android.R.layout.simple_spinner_item, PizzaType.values());
        pizzaType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chicagoSpinner.setAdapter(pizzaType);
        chicagoSpinner.setOnItemSelectedListener(this);
        chicagoCrustText = findViewById(R.id.chicagoCrustText);
        chicagoCrustText.setText(currentPizza.getCrust().toString());
        sizeGroup = findViewById(R.id.sizeGroup);
        smallSize = findViewById(R.id.smallSize);
        mediumSize = findViewById(R.id.mediumSize);
        largeSize = findViewById(R.id.largeSize);
        smallSize.setChecked(true);
        priceText = findViewById(R.id.priceText);
        sizeGroup.setOnCheckedChangeListener(this);


    }


    public void updateCrustAndPic(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 1:
                currentPizza = chicagoPizza.createBBQChicken();
                chicagoCrustText.setText(currentPizza.getCrust().toString());
                break;

            case 0:

                currentPizza = chicagoPizza.createDeluxe();
                chicagoCrustText.setText(currentPizza.getCrust().toString());
                break;

            case 2:

                currentPizza = chicagoPizza.createMeatzza();
                chicagoCrustText.setText(currentPizza.getCrust().toString());
                break;

            case 3:

                currentPizza = chicagoPizza.createBuildYourOwn();
                chicagoCrustText.setText(currentPizza.getCrust().toString());
                break;
        }
        updateSizePrice();


    }

    public void updateSizePrice() {
        if(smallSize.isChecked())
        {
            currentPizza.setSize(Size.Small);
        }
        else if (mediumSize.isChecked())
        {
            currentPizza.setSize(Size.Medium);
        }
        else if (largeSize.isChecked())
        {
            currentPizza.setSize(Size.Large);
        }
        updatePrice();
    }


    private void updatePrice() {
        priceText.setText(String.valueOf(currentPizza.price()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int size) {
        switch (size) {
            case R.id.smallSize:
                currentPizza.setSize(Size.Small);
                break;
            case R.id.mediumSize:
                currentPizza.setSize(Size.Medium);
                break;
            case R.id.largeSize:
                currentPizza.setSize(Size.Large);
                break;
        }
        updatePrice();


    }
}