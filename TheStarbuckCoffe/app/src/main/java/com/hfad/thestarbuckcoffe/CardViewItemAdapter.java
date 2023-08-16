package com.hfad.thestarbuckcoffe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewItemAdapter extends RecyclerView.Adapter<CardViewItemAdapter.ViewHolder> {
    private FoodAndDrink[] foodAndDrinks;
    interface Listener{
        void onClick(int pos);
    }
    private Listener listener;
    public void setListener(Listener listener)
    {
        this.listener = listener;
    }
    public CardViewItemAdapter(FoodAndDrink[] foodAndDrinks) {
        this.foodAndDrinks = foodAndDrinks;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewItemAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.image_id);
        TextView priceView = cardView.findViewById(R.id.price_id);
        TextView nameView = cardView.findViewById(R.id.name_id);
        imageView.setImageResource(foodAndDrinks[position].getIdImage());
        priceView.setText(foodAndDrinks[position].getPrice() + "d");
        nameView.setText(foodAndDrinks[position].getName());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodAndDrinks.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
}
