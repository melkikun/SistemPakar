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


//kesimpulan adapter ini merupakan class yang menampilkan list dari daftar penyakit
public class KesimpulanAdapter extends BaseAdapter {
    //context adalah nama class ini yaitu kesimpulan adapter
    private Context context;
    //inisialisasi hashmap untuk menampung kode penyakit dan gejala
    private HashMap<String, String> hashMap = new HashMap<>();
    //inisialisasi list hasil untuk menampung data centang atau silant
    private List<Integer> hasil = new ArrayList<>();

    //class constructor, ini akan di panggil di kesimpulan.java
    public KesimpulanAdapter(Context context, HashMap<String, String> hashMap, List<Integer> hasil) {
        this.context = context;
        this.hashMap = hashMap;
        this.hasil = hasil;
    }

    //mengambil jumlah list hasil
    @Override
    public int getCount() {
        return hasil.size();
    }

    //mengembalikan nilai counter dari list hasil
    @Override
    public Object getItem(int i) {
        return i;
    }

    //mengambil id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        inisialisasi varibel untuk cek hasil
        int j = i;
        //layout list ditampilkan pada layout custom_kesimpulan di res
        view = LayoutInflater.from(context).inflate(R.layout.custom_kesimpulan, viewGroup, false);
        //inisialisasi text view untuk nama gejala & kode gejala
        TextView gejala = (TextView) view.findViewById(R.id.text);
        //inisialisasi check atau silang pada kesimpulan
        TextView check = (TextView) view.findViewById(R.id.text2);
        //jika hasilnya dari pertanyaan adalah 1 maka akan di lakukan centang
        if (hasil.get(i) == 1) {
            //melakukan centang
            check.setText(Html.fromHtml("&#10003;"));
            //merubah warna menjadi hijau
            check.setTextColor(Color.GREEN);
        } else {
            //menambai tanda silang
            check.setText("x");
            //merubah warna menjadi merah
            check.setTextColor(Color.RED);
        }
        //melakukan set text pada variabel gejala
        gejala.setText((j + 1) + ". " + hashMap.get("G"+(j+1)+""));
        return view;
    }
}
