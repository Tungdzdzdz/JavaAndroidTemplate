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

public class BookItemAdapter extends RecyclerView.Adapter<BookItemAdapter.ViewHolder> {
    private List<Book> bookList;
    public BookItemAdapter(List<Book> list)
    {
        bookList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_bg, parent, false);
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cv;
        ImageView imageView = cardView.findViewById(R.id.image_id);
        TextView textView = cardView.findViewById(R.id.text_id);
        imageView.setImageResource(bookList.get(position).getIdResource());
        textView.setText(bookList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cv;
        public ViewHolder(@NonNull CardView itemView) {
            super(itemView);
            cv = itemView;
        }
    }

}
