package com.example.dinnertracker.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dinnertracker.Adapters.FoodEntriesAdapter;
import com.example.dinnertracker.Food;
import com.example.dinnertracker.R;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dummy data
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("Potatoes",new Date()));
        foodList.add(new Food("Rice",new Date()));
        foodList.add(new Food("Chicken",new Date()));
        foodList.add(new Food("Chicken Soup",new Date()));
        foodList.add(new Food("Fries",new Date()));

        //TODO: implement a database

        //OnClickListener for the Floating Action Button
        findViewById(R.id.fab_menu_addnewentry).setOnClickListener((view) -> {
            Intent intent = new Intent(getApplicationContext(),NewEntryActivity.class);
            getApplicationContext().startActivity(intent);
        });

        //TODO: add a search bar
        //TODO: figure out how to store the list of foods and history(entries) of food
        ListView lvFoodEntries = findViewById(R.id.listview_main_foodentries);
        lvFoodEntries.setAdapter(new FoodEntriesAdapter(this,foodList));
    }
}
