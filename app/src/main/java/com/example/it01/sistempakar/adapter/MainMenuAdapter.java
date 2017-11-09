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

//ini adalah class menu utama akan dipanggil di file dashboard
public class MainMenuAdapter extends BaseAdapter{
    //context merupakan nama class yang di pakai
    private Context context;
    //inisialisasi untuk gambar
    private List<Integer> data = new ArrayList<>();
    //inisialisasi untuk text
    private List<String>text = new ArrayList<>();

    //constructor merupakan sebuah funsgsi yang digunakan untuk inisialisasi, dipanggil di file dashboard
    public MainMenuAdapter(Context context, List<Integer> data, List<String> text) {
        this.context = context;
        this.data = data;
        this.text = text;
    }
    //mengambil jumlah data
    @Override
    public int getCount() {
        return data.size();
    }

    //mengambil index data ke -
    @Override
    public Object getItem(int i) {
        return i;
    }

    //mengambil index data ke -
    @Override
    public long getItemId(int i) {
        return i;
    }

    //fungsi utama
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //layout ini akan di arahkan ke layout main_menu.xml
        //layout inflater digunakan untuk mengarahkan layout
        view = LayoutInflater.from(context).inflate(R.layout.main_menu, viewGroup, false);
        //image view digunakan untuk menampung logo/image
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        //text view digunakan untuk menampung text / judul di dash board
        TextView textView = (TextView) view.findViewById(R.id.text);
        //digunkan untuk melakukan set image pada menggunakan data pda baris ke 27
        imageView.setImageResource(data.get(i));
        //digunkan untuk melakukan set text pada menggunakan data pda baris ke 29
        textView.setText(text.get(i));
        //mengembalikan view layout ke fungsi utama yang nanti akan di panggil
        return view;
    }
}
