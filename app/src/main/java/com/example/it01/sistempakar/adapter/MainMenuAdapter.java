package com.example.it01.sistempakar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it01.sistempakar.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IT01 on 10/20/2017.
 */

public class MainMenuAdapter extends BaseAdapter{
    private Context context;
    private List<Integer> data = new ArrayList<>();
    private List<String>text = new ArrayList<>();

    public MainMenuAdapter(Context context, List<Integer> data, List<String> text) {
        this.context = context;
        this.data = data;
        this.text = text;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.main_menu, viewGroup, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.text);
        imageView.setImageResource(data.get(i));
        textView.setText(text.get(i));
        return view;
    }
}
