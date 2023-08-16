package com.hfad.templateapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.List;

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {
    private List<Book> list;
    public ExpandableRecyclerViewAdapter(List<Book> list)
    {
        this.list = list;
        notifyDataSetChanged();
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
    public ExpandableRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expandable_recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpandableRecyclerViewAdapter.ViewHolder holder, int position) {
        View view = holder.view;
        TextView tv1 = view.findViewById(R.id.tv_title_id);
        ImageView tv2 = view.findViewById(R.id.imageview_id);
        FoldingCell foldingCell = view.findViewById(R.id.folding_cell);
        tv1.setText(list.get(position).getName());
        tv2.setImageResource(list.get(position).getIdResource());
        foldingCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foldingCell.toggle(false);
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(view.getContext(), list.get(position).getName(), Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
