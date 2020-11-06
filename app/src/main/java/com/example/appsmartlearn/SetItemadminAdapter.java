package com.example.appsmartlearn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class SetItemadminAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;
        if(convertView == null)
        {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categoryadmin,parent,false);
        }
        else
        {
            view = convertView;
        }
        ((Button) view.findViewById(R.id.btn_click)).setText(String.valueOf(position+1));
        return view;
    }
}
