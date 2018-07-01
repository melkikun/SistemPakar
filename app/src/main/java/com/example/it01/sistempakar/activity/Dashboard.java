package com.example.it01.sistempakar.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.konsultasi.G01;
import com.example.it01.sistempakar.adapter.MainMenuAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity {
    //mengambil data toolbar di layout
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //mengambil data gridview di layout
    @BindView(R.id.grid_view)
    GridView grid_view;
    //menyimpan variable pertanyaan (session)
    SharedPreferences sharedPreferences2;
    //menampung error
    private final String TAG = getClass().getSimpleName();
    //inisialisasi variabel untuk proses logout
    private int key = 0;
    //class utama
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        layout activity untuk dashboard
        setContentView(R.layout.activity_dashboard);
//        binding data menggunakan butter knife
        ButterKnife.bind(this);
//        set toolbar
        setSupportActionBar(toolbar);
//        judul toolbar
        getSupportActionBar().setTitle("DashBoard");
//        menyimpan session untuk pertanyaan
        sharedPreferences2 = getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
//        inisialisasi list untuk icon
        List<Integer> x = new ArrayList<>();
//        icon diagnosa
        x.add(R.drawable.diagnose);
//        icon petunjuk
        x.add(R.drawable.petunjuk);
//        icon user
        x.add(R.drawable.user);
//        inisialisasi list untuk title
        List<String> y = new ArrayList<>();
//        judul diagnosa
        y.add("Diagnosa");
//        judul petunjuk
        y.add("Petunjuk");
//        judul tentang
        y.add("Tentang");
//        memanggil class adapter untuk inisialisasi grid view
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getApplicationContext(), x, y);
//        set adapter ke grid view
        grid_view.setAdapter(mainMenuAdapter);
//        grid view waktu di click
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
//                    klik icon diagnosa
                    case 0:
//                        peringatan apakah lanjut atau tidak
                        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
//                        judul peringantan
                        builder.setTitle("Konsultasi");
//                        konfirmasi
                        builder.setMessage("Apa anda yakin?");
//                        set button yes
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//                                menghapus semua sesi untuk pertanyaan dan gejala(gejala 1 sampai 20 di berikan nilai 0)
                                sharedPreferences2.edit().clear().commit();
//                                menghilangkan dialog
                                dialog.dismiss();
//                                memulai halaman gejala 01
                                startActivity(new Intent(getApplicationContext(), G01.class));
                            }
                        });
//                        set button no
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing
                                dialog.dismiss();
                            }
                        });
//                        inisialisasi dialog pertanyaan
                        AlertDialog alert = builder.create();
//                        menampilkan dialog pertanyaan
                        alert.show();
                        break;
//                        saat tombol petunjuk di pencet
                    case 1:
//                        pindah halaman ke class petunjuk
                        startActivity(new Intent(getApplicationContext(), Petunjuk.class));
                        break;
                    case 2:
//                        pindah halaman ke class about
                        startActivity(new Intent(getApplicationContext(), About.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

//    saat tombol back dipencet/ketika mau exit
    @Override
    public void onBackPressed() {
        //jika nilai key = 1 maka akan exit aplikasi
        if(key == 1){
            //key dijadikan 0
            key =0;
            //langsung exit
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            //alert untuk memencet tombol back sekali lagi
            Toast.makeText(getApplicationContext(), "press back Button again to exit", Toast.LENGTH_SHORT).show();
            key++;
        }
    }
}





