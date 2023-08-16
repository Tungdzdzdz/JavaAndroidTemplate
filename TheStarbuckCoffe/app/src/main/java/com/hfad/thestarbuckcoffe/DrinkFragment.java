package com.hfad.thestarbuckcoffe;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DrinkFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_drink, container, false);
        CardViewItemAdapter cardViewItemAdapter = new CardViewItemAdapter(getDrinks());
        cardViewItemAdapter.setListener(new CardViewItemAdapter.Listener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.Type, "Drink");
                intent.putExtra(DetailsActivity.Position, pos);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(cardViewItemAdapter);
        return recyclerView;
    }

    private FoodAndDrink[] getDrinks() {
        FoodAndDrink[] drinks = new Drink[Drink.drinks.length];
        for (int i = 0; i < Drink.drinks.length; i++)
            drinks[i] = Drink.drinks[i];
        return drinks;
    }
}