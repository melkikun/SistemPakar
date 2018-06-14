package com.example.it01.sistempakar.activity;

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

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.konsultasi.Kesimpulan;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ScrollView extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    //inisialisasi toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        ButterKnife.bind(this);

        //inisialisasi font menggunakan delius regular ada di folder assets/fonts
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/delius_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        //set toolbar layout
        setSupportActionBar(toolbar);
        //menambahkan icon back paada toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //menambahkan judul toolbar
        getSupportActionBar().setTitle("Kesimpulan");
    }

    //fungsi untuk merubah font (bawaan android)
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //fungsi untuk click menu pada toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //jika di click back maka akan kembali ke halaman utama
            case android.R.id.home:
                //memanggil fungsi kembali ke home
                kembaliKeHome();
                break;
            //jika selesai akan kembali ke halaman utama
            case R.id.utama:
                //memanggil fungsi kembali ke home
                kembaliKeHome();
                break;
        }
        return true;
    }

    //mengambil mneu pada folder res/menu.finish menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.finsih_menu, menu);
        return true;
    }

    //ketika anda melakukan click pada tombol back
    @Override
    public void onBackPressed() {
        kembaliKeHome();
    }

    public void kembaliKeHome() {
//       /dialog / popup untuk konfirmasi
        AlertDialog.Builder builder = new AlertDialog.Builder(ScrollView.this);
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
}
