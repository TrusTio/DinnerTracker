package com.example.dinnertracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinnertracker.Food;
import com.example.dinnertracker.R;

import java.text.DateFormat;
import java.util.ArrayList;

public class FoodEntriesAdapter extends ArrayAdapter<Food> {
    public FoodEntriesAdapter(Context context, ArrayList<Food> foodList) {
        super(context, R.layout.item_food_entries, foodList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_food_entries, parent, false);
        }
        final Food currentFood = getItem(position);

        //Load the fields with data from the Food
        TextView tvFoodName = listItemView.findViewById(R.id.textview_foodentries_name);
        tvFoodName.setText(currentFood.getName());

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        TextView tvFoodNumDate = listItemView.findViewById(R.id.textview_foodentries_numdate);
        tvFoodNumDate.setText(dateFormat.format(currentFood.getDate()));

        return listItemView;
    }
}
