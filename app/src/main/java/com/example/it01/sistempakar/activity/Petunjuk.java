package com.example.it01.sistempakar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.it01.sistempakar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//codingan ini di gunakan untuk menampilkan halaman petunjuk
public class Petunjuk extends AppCompatActivity {
    //digunakan untuk binding data ke xml dengan nama toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;//inisialisasi toolbar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        codingan bawaan android
        super.onCreate(savedInstanceState);
        //diarahkan ke nama layout activity about pada folder res/layout/activity_petunjuk.xml
        setContentView(R.layout.activity_petunjuk);
        //inisialisasi butter knife untuk binding data pada class ini
        ButterKnife.bind(this);
        //inisialisasi toolbar
        setSupportActionBar(toolbar);
        //mengganti judul toolbar
        getSupportActionBar().setTitle("Petunjuk Sistem Pakar");
        //menambahkan icon back di samping kiri judul toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //fungssi / method pada saat di tekan panah kiri di pojok kiri atas toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
        //jika tombol back di toolbar di click
            case android.R.id.home:
                //close aplikasi fungsi finish ini di gunakan untuk menutup aplikasi
                finish();
                break;
        }
        return true;
    }
}
