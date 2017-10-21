package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.it01.sistempakar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class G02 extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    @BindView(R.id.radio)
    RadioGroup radioGroup;
    @BindView(R.id.ya)
    RadioButton ya;
    @BindView(R.id.tidak)
    RadioButton tidak;
    RadioButton choosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konsultasi02);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pertanyaan Kedua");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        if(sharedPreferences.contains("G02")){
            int data = sharedPreferences.getInt("G02", 0);
            if(data == 1){
                ya.setChecked(true);
            }else{
                tidak.setChecked(false);
            }
        }else{
            tidak.setChecked(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }
        return true;
    }

    @OnClick(R.id.lanjut)
    public void lanjut(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        choosen = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String value = choosen.getText().toString();
        if(value.equalsIgnoreCase("ya")){
            editor.putInt("G02", 1);
        }else{
            editor.putInt("G02", 0);
        }
        editor.commit();
        startActivity(new Intent(this, Kesimpulan.class));
    }

    @OnClick(R.id.kembali)
    public void kembali(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        choosen = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String value = choosen.getText().toString();
        if(value.equalsIgnoreCase("ya")){
            editor.putInt("G02", 1);
        }else{
            editor.putInt("G02", 0);
        }
        editor.commit();
        finish();
    }
}
