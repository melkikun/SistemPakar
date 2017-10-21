package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.Dashboard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Kesimpulan extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    //    @BindView(R.id.g01)
//    TextView g01;
//    @BindView(R.id.g02)
//    TextView g02;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
//    @BindView(R.id.list_view)
//    ListView list_view;
    @BindView(R.id.selesai)
    Button selesai;
    @BindView(R.id.simpan)
    Button simpan;
    private String[] kodeGejala;
    private String[] namaGejala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);
        ButterKnife.bind(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/art_rewery.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
//        Calligrapher calligrapher = new Calligrapher(this);
//        calligrapher.setFont(this, "font/art_rewery.ttf", true);
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        int gejala1 = sharedPreferences.getInt("G01", 9999);
        int gejala2 = sharedPreferences.getInt("G02", 9999);
//        g01.setText("mual : " + gejala1 + "");
//        g02.setText("demam" + gejala2 + "");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Kesimpulan");
        kodeGejala = new String[2];
        namaGejala = new String[2];

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @OnClick(R.id.selesai)
    public void selesai() {
        startActivity(new Intent(this, Dashboard.class));
    }

    @OnClick(R.id.simpan)
    public void simpan(){
        Toast.makeText(getApplicationContext(), "Masih dalam perbaikan", Toast.LENGTH_SHORT).show();
    }
}
