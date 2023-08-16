package com.hfad.thestarbuckcoffe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageSilderAdapter extends RecyclerView.Adapter<ImageSilderAdapter.ViewHolder> {
    private Photo[] photos;
    public ImageSilderAdapter(Photo[] photos)
    {
        this.photos = photos;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
    }
    @NonNull
    @Override
    public ImageSilderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageSilderAdapter.ViewHolder holder, int position) {
        View view = holder.view;
        ImageView imageView = view.findViewById(R.id.image_slider_id);
        imageView.setImageResource(photos[position].getIdImage());
    }

    @Override
    public int getItemCount() {
        return photos.length;
    }
}
