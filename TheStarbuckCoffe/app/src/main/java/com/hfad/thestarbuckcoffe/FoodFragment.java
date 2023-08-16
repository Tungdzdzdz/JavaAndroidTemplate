package com.hfad.thestarbuckcoffe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FoodFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_food, container, false);
        CardViewItemAdapter cardViewItemAdapter = new CardViewItemAdapter(getFoods());
        cardViewItemAdapter.setListener(new CardViewItemAdapter.Listener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.Type, "Food");
                intent.putExtra(DetailsActivity.Position, pos);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(cardViewItemAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        return recyclerView;
    }

    private FoodAndDrink[] getFoods() {
        FoodAndDrink[] foods;
        foods = new Food[3];
        for (int i = 0; i < Food.foods.length; i++) {
            foods[i] = Food.foods[i];
        }
        return foods;
    }
}