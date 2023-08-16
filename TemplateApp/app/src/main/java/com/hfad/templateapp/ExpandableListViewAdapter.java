package com.hfad.templateapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private List<String> list;
    private Map<String, List<Book>> map;
    public ExpandableListViewAdapter(List<String> books, Map<String, List<Book>> map)
    {
        this.list = books;
        this.map = map;
    }
    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return map.get(list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return map.get(list.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        String string = list.get(i);
        return string.hashCode();
    }

    @Override
    public long getChildId(int i, int i1) {
        return map.get(list.get(i)).get(i1).getIdResource();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_group, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.text_view_group_id);
        textView.setText(list.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.textview_item_id);
        textView.setText(map.get(list.get(i)).get(i1).getName());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
