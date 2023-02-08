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
        TextView col0_listId = (TextView) view.findViewById(R.id.textView);
        TextView col1_id = (TextView) view.findViewById(R.id.textView1);
        TextView col2_name = (TextView) view.findViewById(R.id.textView2);
        col0_listId.setText(listId[i]);
        col1_id.setText(id[i]);
        col2_name.setText(name[i]);
        return view;
    }
}
