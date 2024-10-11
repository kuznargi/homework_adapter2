package com.eco.adapters2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private static LayoutInflater layoutInflater;
    private ArrayList<String> titles;
    private ArrayList<Integer> icons;
    public CustomAdapter(Context context,ArrayList<String> titles,ArrayList<Integer> icons) {
        this.context=context;
        this.titles=titles;
        this.icons=icons;
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return getItemId(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= convertView;
        if(row==null){
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.list_of_row,null);

        }
        ImageView img=row.findViewById(R.id.img);
        TextView text=row.findViewById(R.id.title);
        img.setImageResource(icons.get(position));
        text.setText(titles.get(position));
        return row;

    }
}
