package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.Dashboard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class G03 extends AppCompatActivity {
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
        setContentView(R.layout.activity_g03);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pertanyaan 3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        if(sharedPreferences.contains("G03")){
            int data = sharedPreferences.getInt("G03", 0);
            if(data == 1){
                ya.setChecked(true);
            }else{
                tidak.setChecked(true);
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
            case R.id.utama:
                AlertDialog.Builder builder = new AlertDialog.Builder(G03.this);

                builder.setTitle("Konsultasi");
                builder.setMessage("Apa anda yakin kembali, data anda akan hilang?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        startActivity(new Intent(getApplicationContext(), Dashboard.class));
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                break;
            case R.id.selesai:
                startActivity(new Intent(getApplicationContext(), Kesimpulan.class));
                break;
        }
        return true;
    }

    @OnClick(R.id.lanjut)
    public void lanjut(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        choosen = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String value = choosen.getText().toString();
        if(value.equalsIgnoreCase("ya")){
            editor.putInt("G03", 1);
        }else{
            editor.putInt("G03", 0);
        }
        editor.commit();
        startActivity(new Intent(this, G04.class));
    }

    @OnClick(R.id.kembali)
    public void kembali(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        choosen = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String value = choosen.getText().toString();
        if(value.equalsIgnoreCase("ya")){
            editor.putInt("G03", 1);
        }else{
            editor.putInt("G03", 0);
        }
        editor.commit();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.diagnosa_menu, menu);
        return true;
    }
}
