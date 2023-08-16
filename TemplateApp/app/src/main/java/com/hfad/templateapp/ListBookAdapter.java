package com.hfad.templateapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

public class ListBookAdapter extends BaseAdapter implements StickyListHeadersAdapter {
    private Context context;
    public ListBookAdapter(Context context)
    {
        this.context = context;
    }
    private List<Book> bookList;
    public void setData(List<Book> list)
    {
        this.bookList = list;
        notifyDataSetChanged();
    }
    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderViewHolder headerViewHolder;
        if(convertView == null)
        {
            headerViewHolder = new HeaderViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_header_item, parent, false);
            headerViewHolder.textView = convertView.findViewById(R.id.textview_header_id);
            convertView.setTag(headerViewHolder);
        }
        else {
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        }
        headerViewHolder.textView.setText(String.valueOf(bookList.get(position).getName().charAt(0)));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return bookList.get(position).getName().charAt(0);
    }

    @Override
    public int getCount() {
        return this.bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return this.bookList.get(i).getName();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewHolder itemViewHolder;
        if(view == null)
        {
            view = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
            itemViewHolder = new ItemViewHolder();
            itemViewHolder.textView = view.findViewById(R.id.textview_item_id);
            view.setTag(itemViewHolder);
        }
        else
        {
            itemViewHolder = (ItemViewHolder) view.getTag();
        }
        itemViewHolder.textView.setText(bookList.get(i).getName());
        return view;
    }
    public class HeaderViewHolder{
        private TextView textView;
    }
    public class ItemViewHolder{
        private TextView textView;
    }
}
