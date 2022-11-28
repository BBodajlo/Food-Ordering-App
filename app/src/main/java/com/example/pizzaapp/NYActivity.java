package com.example.pizzaapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NYActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener{
    private Spinner newyorkSpinner;
    private TextView newyorkCrustText;
    private TextView newyorkSizeText;
    private PizzaFactory newyorkPizza = new NYPizza();
    private Pizza currentPizza;
    private ArrayAdapter<PizzaType> pizzaType;
    private RadioGroup sizeGroup;
    private RadioButton smallSize;
    private RadioButton mediumSize;
    private RadioButton largeSize;
    private TextView priceText;
    private ListView toppingsList;
    private ArrayAdapter<Topping> toppingsArray;
    private Button addPizzaButton;
    private Order testOrder;
    private ImageView pizzaPicture;
    private final static int MAX_TOPPINGS = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny);
        currentPizza = newyorkPizza.createDeluxe();
        currentPizza.setSize(Size.Small);
        newyorkSpinner = findViewById(R.id.newyorkSpinner);
        pizzaType = new ArrayAdapter<PizzaType>(this, android.R.layout.simple_spinner_item, PizzaType.values());
        pizzaType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        newyorkSpinner.setAdapter(pizzaType);
        newyorkSpinner.setOnItemSelectedListener(this);
        newyorkCrustText = findViewById(R.id.newyorkCrustText);
        newyorkCrustText.setText(currentPizza.getCrust().toString());
        sizeGroup = findViewById(R.id.sizeGroup);
        smallSize = findViewById(R.id.smallSize);
        mediumSize = findViewById(R.id.mediumSize);
        largeSize = findViewById(R.id.largeSize);
        smallSize.setChecked(true);
        priceText = findViewById(R.id.priceText);
        sizeGroup.setOnCheckedChangeListener(this);
        toppingsArray = new ArrayAdapter<Topping>(this, android.R.layout.simple_list_item_multiple_choice, Topping.values());
        toppingsList = findViewById(R.id.toppingsList);
        toppingsList.setAdapter(toppingsArray);
        toppingsList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        toppingsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                updateToppings();
                updatePrice();
            }
        });

        addPizzaButton = findViewById(R.id.addPizzaButton);
        addPizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPizzaToOrder();
            }
        });
        testOrder = new Order(1);
        pizzaPicture = findViewById(R.id.pizzaPicture);



    }


    public void updateCrustAndPic(View view) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Bitmap pic;
        switch (position) {
            case 1:
                currentPizza = newyorkPizza.createBBQChicken();
                newyorkCrustText.setText(currentPizza.getCrust().toString());
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.chickenny);
                pizzaPicture.setImageBitmap(pic);
                break;

            case 0:

                currentPizza = newyorkPizza.createDeluxe();
                newyorkCrustText.setText(currentPizza.getCrust().toString());
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.deluxeny);
                pizzaPicture.setImageBitmap(pic);
                break;

            case 2:

                currentPizza = newyorkPizza.createMeatzza();
                newyorkCrustText.setText(currentPizza.getCrust().toString());
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.meatny);
                pizzaPicture.setImageBitmap(pic);
                break;

            case 3:

                currentPizza = newyorkPizza.createBuildYourOwn();
                newyorkCrustText.setText(currentPizza.getCrust().toString());
                pic = BitmapFactory.decodeResource(getResources(), R.drawable.byony);
                pizzaPicture.setImageBitmap(pic);
                break;
        }

        handleToppingsList();
        updateSizePrice();

        if(!(currentPizza instanceof BuildYourOwn))
        {
            toppingsList.setEnabled(false);
        }
        else{
            toppingsList.setEnabled(true);
        }



    }

    public void updateToppings()
    {

        if(currentPizza instanceof BuildYourOwn)
        {
            currentPizza.getToppings().clear();
            SparseBooleanArray itemsChecked = toppingsList.getCheckedItemPositions();

            for(int i = 0; i < toppingsArray.getCount(); i++)
            {
                if(itemsChecked.get(i))
                {
                    currentPizza.add(toppingsArray.getItem(i));
                }
            }
        }
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

    private void handleToppingsList()
    {
        toppingsList.clearChoices();
        resetToppingArray();
        if(!(currentPizza instanceof BuildYourOwn)) {
        toppingsArray = new ArrayAdapter<Topping>(this, android.R.layout.simple_list_item_multiple_choice);
        toppingsArray.addAll(currentPizza.getToppings());
        toppingsList.setAdapter(toppingsArray);
            for (int i = 0; i < toppingsArray.getCount(); i++) {
                toppingsList.setItemChecked(i, true);
            }
        }
        else
        {
            toppingsList.setAdapter(toppingsArray);
        }


    }

    private void resetToppingArray()
    {
        toppingsArray = new ArrayAdapter<Topping>(this, android.R.layout.simple_list_item_multiple_choice, Topping.values());
    }

    public void addPizzaToOrder() {
        updateToppings();
        if (validNumOfToppings()) {
            ArrayList<Topping> tempToppings = currentPizza.getToppings();
            Size tempSize = currentPizza.getSize();
            Crust tempCrust = currentPizza.getCrust();

            OrderActivity.getCurrentOrder().add(currentPizza);
            OrderActivity.updateList();
            System.out.print(OrderActivity.getCurrentOrder().toString());

            if (currentPizza instanceof BuildYourOwn) {
                currentPizza = newyorkPizza.createBuildYourOwn();
                currentPizza.setSize(tempSize);
                currentPizza.setCrust(tempCrust);
                currentPizza.initializeToppings();
                for (Topping t : tempToppings) {
                    currentPizza.add(t);
                }
            } else if (currentPizza instanceof Meatzza) {
                currentPizza = newyorkPizza.createMeatzza();
                currentPizza.setSize(tempSize);
            } else if (currentPizza instanceof BBQChicken) {
                currentPizza = newyorkPizza.createBBQChicken();
                currentPizza.setSize(tempSize);
            } else if (currentPizza instanceof Deluxe) {
                currentPizza = newyorkPizza.createDeluxe();
                currentPizza.setSize(tempSize);
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Too many toppings!", Toast.LENGTH_SHORT).show();
        }
    }


    private boolean validNumOfToppings()
    {
        if(currentPizza.getToppings().size() > MAX_TOPPINGS)
        {
            return false;
        }
        return true;
    }

}