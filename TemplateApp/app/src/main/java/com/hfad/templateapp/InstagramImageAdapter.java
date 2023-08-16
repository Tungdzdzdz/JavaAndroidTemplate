package com.hfad.templateapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InstagramImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int SmallViewType = 1, LargeViewType = 2;
    private List<List<Book1>> list;
    private Context context;
    public InstagramImageAdapter(Context context, List<List<Book1>> list)
    {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }
    public class SmallViewHolder extends RecyclerView.ViewHolder{
        private View view;
        public SmallViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
    public class LargeViewHolder extends RecyclerView.ViewHolder{
        private View view;
        public LargeViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
    @Override
    public int getItemViewType(int position) {
        return list.get(position).get(0).getViewType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType == SmallViewType)
        {
            view = (View) LayoutInflater.from(context).inflate(R.layout.small_image_item_layout, parent, false);
            return new SmallViewHolder(view);
        }
        else
        {
            view = (View) LayoutInflater.from(context).inflate(R.layout.large_image_item_layout, parent, false);
            return new LargeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.get(position).get(0).getViewType() == SmallViewType)
        {
            SmallViewHolder smallViewHolder = (SmallViewHolder) holder;
            View view = smallViewHolder.view;
            ImageView imageView1 = view.findViewById(R.id.image1_id);
            ImageView imageView2 = view.findViewById(R.id.image2_id);
            ImageView imageView3 = view.findViewById(R.id.image3_id);
            imageView1.setImageResource(list.get(position).get(0).getIdResource());
            imageView2.setImageResource(list.get(position).get(1).getIdResource());
            imageView3.setImageResource(list.get(position).get(2).getIdResource());
        }
        else {
            LargeViewHolder largeViewHolder = (LargeViewHolder) holder;
            View view = largeViewHolder.view;
            ImageView imageView1 = view.findViewById(R.id.image1_id);
            ImageView imageView2 = view.findViewById(R.id.image2_id);
            ImageView imageView3 = view.findViewById(R.id.image3_id);
            imageView1.setImageResource(list.get(position).get(0).getIdResource());
            imageView2.setImageResource(list.get(position).get(1).getIdResource());
            imageView3.setImageResource(list.get(position).get(2).getIdResource());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
