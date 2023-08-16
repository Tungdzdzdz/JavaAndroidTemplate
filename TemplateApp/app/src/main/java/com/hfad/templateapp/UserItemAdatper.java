package com.hfad.templateapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserItemAdatper extends RecyclerView.Adapter<UserItemAdatper.ViewHolder> {
    private List<User> userList;
    public UserItemAdatper(List<User> list)
    {
        userList = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cardView = itemView;
        }
    }
    @NonNull
    @Override
    public UserItemAdatper.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_bg, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserItemAdatper.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.image_id);
        TextView textView = cardView.findViewById(R.id.text_id);
        imageView.setImageResource(userList.get(position).getIdResource());
        textView.setText(userList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
