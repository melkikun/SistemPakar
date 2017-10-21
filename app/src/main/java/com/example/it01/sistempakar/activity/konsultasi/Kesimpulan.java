package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.it01.sistempakar.R;

public class Kesimpulan extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        String g01 = sharedPreferences.getString("G01", "xxxxx");
        Toast.makeText(getApplicationContext(), g01, Toast.LENGTH_SHORT).show();
    }
}
