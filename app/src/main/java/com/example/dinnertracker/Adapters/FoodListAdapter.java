package com.example.dinnertracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinnertracker.Food;
import com.example.dinnertracker.R;

import java.util.ArrayList;

public class FoodListAdapter extends ArrayAdapter<Food> {
    public FoodListAdapter(Context context, ArrayList<Food> foodList) {
        super(context, R.layout.item_food_entries, foodList);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_food_list, parent, false);
        }
        final Food currentFood = getItem(position);

        //Load the fields with data from the Food
        TextView tvFoodName = listItemView.findViewById(R.id.textview_foodlist_name);
        tvFoodName.setText(currentFood.getName());
        LinearLayout layoutFoodListItem = listItemView.findViewById(R.id.linearlayout_foodlist_item);
        layoutFoodListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),tvFoodName.getText(),Toast.LENGTH_LONG).show();
            }
        });
        ImageView ivFoodImage = listItemView.findViewById(R.id.imageview_foodlist_picture);


        return listItemView;
    }
}
