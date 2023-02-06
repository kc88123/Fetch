package com.example.fetch;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] listId;
    String[] id;
    String[] name;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] listId, String[] id, String[] name) {
        this.context = context;
        this.listId = listId;
        this.id = id;
        this.name = name;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return listId.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.text_view, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
        TextView country1 = (TextView) view.findViewById(R.id.textView1);
        TextView country2 = (TextView) view.findViewById(R.id.textView2);
        country.setText(listId[i]);
        country1.setText(id[i]);
        country2.setText(name[i]);
        return view;
    }
}
