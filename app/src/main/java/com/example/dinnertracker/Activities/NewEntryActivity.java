package com.example.dinnertracker.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.dinnertracker.Adapters.FoodListAdapter;
import com.example.dinnertracker.DatePickerFragment;
import com.example.dinnertracker.Food;
import com.example.dinnertracker.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NewEntryActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        //TODO: build the layout for the activity
        //TODO: add a list activity for the food choosing
        //TODO: new activity and class for new food type

        //dummy data
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Potatoes",new Date()));
        foodList.add(new Food("Rice",new Date()));
        foodList.add(new Food("Chicken",new Date()));
        foodList.add(new Food("Chicken Soup",new Date()));
        foodList.add(new Food("Fries",new Date()));


        ListView lvFoodList = findViewById(R.id.listview_newentry_foodlist);
        lvFoodList.setAdapter(new FoodListAdapter(this, foodList));

        Button btnNewFood = findViewById(R.id.button_newentry_newfoodlist);
        btnNewFood.setOnClickListener((view -> {
            Intent intent = new Intent(getApplicationContext(), NewFoodListEntryActivity.class);
            getApplicationContext().startActivity(intent);
        }));


        Button btnDate = findViewById(R.id.button_newentry_pickdate);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        btnDate.setText(dateFormat.format(new Date()));
        btnDate.setOnClickListener((view) -> {
            DatePickerFragment newFragment = new DatePickerFragment();
            newFragment.init(this,this);
            newFragment.show(getSupportFragmentManager(), "datePicker");
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Button btnDate = findViewById(R.id.button_newentry_pickdate);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        btnDate.setText(dateFormat.format(new Date(i,i1,i2)));
    }
}
