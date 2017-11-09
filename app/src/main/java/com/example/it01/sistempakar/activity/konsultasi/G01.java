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
import android.widget.Toast;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.Dashboard;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class G01 extends AppCompatActivity {
    //mengambil data toolbar di layout
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //menyimpan variable pertanyaan (session) pertama(gejala pertama)
    SharedPreferences sharedPreferences;
    //inisialisasi radio group
    @BindView(R.id.radio)
    RadioGroup radioGroup;
//    inisialisasi radio button yes
    @BindView(R.id.ya)
    RadioButton ya;
//    inisialisasi radio button no
    @BindView(R.id.tidak)
    RadioButton tidak;
//    inisialisasi pemilihan radio button
    RadioButton choosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //lauout untuk pertanyaan pertama
        setContentView(R.layout.activity_g01);
        //inisialisasi butter knife untuk data binding
        ButterKnife.bind(this);
        //set toolbar
        setSupportActionBar(toolbar);
        //set judul toolbar
        getSupportActionBar().setTitle("Pertanyaan 1");
        //set tombol back toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //inisialisasi sharepreferences atau session untuk pertanyaan
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        //menampung hasil pertanyaan pertama
        if(sharedPreferences.contains("G01")){
            int data = sharedPreferences.getInt("G01", 0);
            //jika pertanyaan pertama bernilai 1 maka checkbox ya di set checkked
            if(data == 1){
                ya.setChecked(true);
            }else{
                //jika pertanyaan pertama bernilai 0 maka checkbox tidak di set checkked
                tidak.setChecked(true);
            }
        }else{
            ////jika pertanyaan pertama belum bernilai apa2 maka tidak di set checkked
            tidak.setChecked(true);
        }
    }

    //button pada pojok kanan
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //kembali ke halaman home
                dialogBack();
                break;
            case R.id.selesai:
                //langsung ke halaman selesai
                startActivity(new Intent(getApplicationContext(), Kesimpulan.class));
                break;
                //kembali ke halaman utama
            case R.id.utama:
                dialogBack();
        }
        return true;
    }

    //saaat di click tombol lanjut
    @OnClick(R.id.lanjut)
    public void lanjut(){
        //menyimpan nilai dari radio button ya dan tidak
        SharedPreferences.Editor editor = sharedPreferences.edit();
        choosen = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String value = choosen.getText().toString();
        //jika di click ya maka gejala 1 (G01) diberikan nilai 1
        if(value.equalsIgnoreCase("ya")){
        editor.putInt("G01", 1);
        }else{
            //jika di click tidak maka gejala 1 (G01) diberikan nilai 0
            editor.putInt("G01", 0);
        }
        //commit session
        editor.commit();
//        memulai halaman ke dua
        startActivity(new Intent(this, G02.class));
    }

    //saat di click tombol kembali
    @OnClick(R.id.kembali)
    public void kembali(){
        dialogBack();
    }

    @Override
    public void onBackPressed() {
        dialogBack();
    }

    //konfirmasi ke halaman home
    public void dialogBack(){
        //dialog / popup untuk konfirmasi
        AlertDialog.Builder builder = new AlertDialog.Builder(G01.this);
        //judul dialog / pop up
        builder.setTitle("Konsultasi");
        // pesan konfirmasi pada pop up
        builder.setMessage("Apa anda yakin kembali, data anda akan hilang?");

        //tombol yes
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            }
        });
        //tombol no
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });

        //membuat object alert dari pop up/alert dialog
        AlertDialog alert = builder.create();
        //menampilkan pop up
        alert.show();
    }


    //membuat menu pjok kanan dari menu diagnosa di foler menu pada res
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.diagnosa_menu, menu);
        return true;
    }
}
