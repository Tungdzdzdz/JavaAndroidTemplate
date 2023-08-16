package com.hfad.templateapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {
    private List<Book> list;
    public ItemRecyclerViewAdapter(List<Book> list)
    {
        this.list = list;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public ItemRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewAdapter.ViewHolder holder, int position) {
        View view = holder.view;
        TextView textView = view.findViewById(R.id.textview_item_id);
        textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
