package com.example.it01.sistempakar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.it01.sistempakar.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by IT01 on 10/21/2017.
 */

public class KesimpulanAdapter extends BaseAdapter {
    private Context context;
    private HashMap<String, String> hashMap = new HashMap<>();
    private List<Integer> hasil = new ArrayList<>();
    private int no = 1;
    private String key = "G";

    public KesimpulanAdapter(Context context, HashMap<String, String> hashMap, List<Integer> hasil) {
        this.context = context;
        this.hashMap = hashMap;
        this.hasil = hasil;
    }

    @Override
    public int getCount() {
        return hasil.size();
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
        int j = i;
        view = LayoutInflater.from(context).inflate(R.layout.custom_kesimpulan, viewGroup, false);
        TextView gejala = (TextView) view.findViewById(R.id.text);
        TextView check = (TextView) view.findViewById(R.id.text2);
        if (hasil.get(i) == 1) {
            check.setText(Html.fromHtml("&#10003;"));
            check.setTextColor(Color.GREEN);
        } else {
            check.setText("x");
            check.setTextColor(Color.RED);
        }
        gejala.setText((j + 1) + ". " + hashMap.get("G"+(j+1)+""));
        return view;
    }
}
