package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it01.sistempakar.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Kesimpulan extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @BindView(R.id.g01)
    TextView g01;
    @BindView(R.id.g02)
    TextView g02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);
        ButterKnife.bind(this);
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        int gejala1 = sharedPreferences.getInt("G01", 9999);
        int gejala2 = sharedPreferences.getInt("G02", 9999);
        g01.setText("mual : " + gejala1 + "");
        g02.setText("demam" + gejala2 + "");
    }
}
