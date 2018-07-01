package com.example.it01.sistempakar.activity.konsultasi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.Dashboard;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Kesimpulan extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    //inisialisasi toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mual)
    TextView mual;
    @BindView(R.id.muntah)
    TextView muntah;
    @BindView(R.id.nyeriperut)
    TextView nyeriperut;
    @BindView(R.id.diare)
    TextView diare;
    @BindView(R.id.sesaknafas)
    TextView sesaknafas;
    @BindView(R.id.tensimenurun)
    TextView tensimenurun;
    @BindView(R.id.pusing)
    TextView pusing;
    @BindView(R.id.sakitperut)
    TextView sakitperut;
    @BindView(R.id.sakitkepala)
    TextView sakitkepala;
    @BindView(R.id.kehilanganseleramakan)
    TextView kehilanganseleramakan;
    @BindView(R.id.babcair)
    TextView babcair;
    @BindView(R.id.diarecampurdarah)
    TextView diarecampurdarah;
    @BindView(R.id.panas)
    TextView panas;
    @BindView(R.id.kelelahan)
    TextView kelelahan;
    @BindView(R.id.perutkram)
    TextView perutkram;
    @BindView(R.id.penurunanbb)
    TextView penurunanbb;
    @BindView(R.id.sakitotot)
    TextView sakitotot;
    @BindView(R.id.kulitkering)
    TextView kulitkering;
    @BindView(R.id.tidakbab)
    TextView tidakbab;
    @BindView(R.id.haus)
    TextView haus;
    @BindView(R.id.matacekung)
    TextView matacekung;

    @BindView(R.id.solusi)
    TextView solusiText;

    //keracunan makanan table
    @BindView(R.id.analisakeracunanmakanan)
    TextView analisakeracunanmakanan;
    @BindView(R.id.prosentasekeracunanmakanan)
    TextView prosentasekeracunanmakanan;
    @BindView(R.id.jumlahkeracunanmakanan)
    TextView jumlahkeracunanmakanan;

    //diare table
    @BindView(R.id.analisadiare)
    TextView analisadiare;
    @BindView(R.id.prosentasediare)
    TextView prosentasediare;
    @BindView(R.id.jumlahdiare)
    TextView jumlahdiare;

    //radang usus table
    @BindView(R.id.analisaradangusus)
    TextView analisaradangusus;
    @BindView(R.id.prosentaseradangusus)
    TextView prosentaseradangusus;
    @BindView(R.id.jumlahradangusus)
    TextView jumlahradangusus;

    //e coli table
    @BindView(R.id.analisecoli)
    TextView analisecoli;
    @BindView(R.id.prosentaseecoli)
    TextView prosentaseecoli;
    @BindView(R.id.jumlahecoli)
    TextView jumlahecoli;

    //GASTRO table
    @BindView(R.id.analisagastro)
    TextView analisagastro;
    @BindView(R.id.prosentasegastro)
    TextView prosentasegastro;
    @BindView(R.id.jumlahgastro)
    TextView jumlahgastro;

    //rota table
    @BindView(R.id.analisarota)
    TextView analisarota;
    @BindView(R.id.prosentaserota)
    TextView prosentaserota;
    @BindView(R.id.jumlahrota)
    TextView jumlahrota;

    //kesimpulan solusi_keracunan_makanan
    @BindView(R.id.solusi_keracunan_makanan)
    LinearLayout solusi_keracunan_makanan;
    //kesimpulan solusi_diare
    @BindView(R.id.solusi_diare)
    LinearLayout solusi_diare;
    //kesimpulan solusi_rading_usus
    @BindView(R.id.solusi_rading_usus)
    LinearLayout solusi_rading_usus;
    //kesimpulan solusi_e_coli
    @BindView(R.id.solusi_e_coli)
    LinearLayout solusi_e_coli;
    //kesimpulan solusi_gastro
    @BindView(R.id.solusi_gastro)
    LinearLayout solusi_gastro;
    //kesimpulan solusi_rota
    @BindView(R.id.solusi_rota)
    LinearLayout solusi_rota;

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

        //mengambil data session pertanyaan yang telah disimpan di setiap session (sharedpreferences anggap saja session)
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        int gejala1 = sharedPreferences.getInt("G01", 0); //mengambil data dari gejala 1 berisi 0 atau 1(0 tidak, 1 ya)
        int gejala2 = sharedPreferences.getInt("G02", 0);//mengambil data dari gejala 1 berisi 0 atau 2(0 tidak, 1 ya)
        int gejala3 = sharedPreferences.getInt("G03", 0);//mengambil data dari gejala 1 berisi 0 atau 3(0 tidak, 1 ya)
        int gejala4 = sharedPreferences.getInt("G04", 0);//mengambil data dari gejala 1 berisi 0 atau 4(0 tidak, 1 ya)
        int gejala5 = sharedPreferences.getInt("G05", 0);//mengambil data dari gejala 1 berisi 0 atau 5(0 tidak, 1 ya)
        int gejala6 = sharedPreferences.getInt("G06", 0);//mengambil data dari gejala 1 berisi 0 atau 6(0 tidak, 1 ya)
        int gejala7 = sharedPreferences.getInt("G07", 0);//mengambil data dari gejala 1 berisi 0 atau 7(0 tidak, 1 ya)
        int gejala8 = sharedPreferences.getInt("G08", 0);//mengambil data dari gejala 1 berisi 0 atau 8(0 tidak, 1 ya)
        int gejala9 = sharedPreferences.getInt("G09", 0);//mengambil data dari gejala 1 berisi 0 atau 9(0 tidak, 1 ya)
        int gejala10 = sharedPreferences.getInt("G10", 0);//mengambil data dari gejala 1 berisi 0 atau 10(0 tidak, 1 ya)
        int gejala11 = sharedPreferences.getInt("G11", 0);//mengambil data dari gejala 1 berisi 0 atau 11(0 tidak, 1 ya)
        int gejala12 = sharedPreferences.getInt("G12", 0);//mengambil data dari gejala 1 berisi 0 atau 12(0 tidak, 1 ya)
        int gejala13 = sharedPreferences.getInt("G13", 0);//mengambil data dari gejala 1 berisi 0 atau 13(0 tidak, 1 ya)
        int gejala14 = sharedPreferences.getInt("G14", 0);//mengambil data dari gejala 1 berisi 0 atau 14(0 tidak, 1 ya)
        int gejala15 = sharedPreferences.getInt("G15", 0);//mengambil data dari gejala 1 berisi 0 atau 15(0 tidak, 1 ya)
        int gejala16 = sharedPreferences.getInt("G16", 0);//mengambil data dari gejala 1 berisi 0 atau 16(0 tidak, 1 ya)
        int gejala17 = sharedPreferences.getInt("G17", 0);//mengambil data dari gejala 1 berisi 0 atau 17(0 tidak, 1 ya)
        int gejala18 = sharedPreferences.getInt("G18", 0);//mengambil data dari gejala 1 berisi 0 atau 18(0 tidak, 1 ya)
        int gejala19 = sharedPreferences.getInt("G19", 0);//mengambil data dari gejala 1 berisi 0 atau 19(0 tidak, 1 ya)
        int gejala20 = sharedPreferences.getInt("G20", 0);//mengambil data dari gejala 1 berisi 0 atau 20(0 tidak, 1 ya)
        int gejala21 = sharedPreferences.getInt("G21", 0);//mengambil data dari gejala 1 berisi 0 atau 20(0 tidak, 1 ya)

        //1. mual
        if (gejala1 == 1) {
            mual.setText(Html.fromHtml("&#x2713;"));
        } else {
            mual.setText("x");
        }
        //2. muntah
        if (gejala2 == 1) {
            muntah.setText(Html.fromHtml("&#x2713;"));
        } else {
            muntah.setText("x");
        }
        //3. nyeri perut
        if (gejala3 == 1) {
            nyeriperut.setText(Html.fromHtml("&#x2713;"));
        } else {
            nyeriperut.setText("x");
        }
        //4. diare
        if (gejala4 == 1) {
            diare.setText(Html.fromHtml("&#x2713;"));
        } else {
            diare.setText("x");
        }
        //5. sesak nafas
        if (gejala5 == 1) {
            sesaknafas.setText(Html.fromHtml("&#x2713;"));
        } else {
            sesaknafas.setText("x");
        }
        //6. tensi menurun
        if (gejala6 == 1) {
            tensimenurun.setText(Html.fromHtml("&#x2713;"));
        } else {
            tensimenurun.setText("x");
        }
        //7. pusing
        if (gejala7 == 1) {
            pusing.setText(Html.fromHtml("&#x2713;"));
        } else {
            pusing.setText("x");
        }
        //8. sakit perut
        if (gejala8 == 1) {
            sakitperut.setText(Html.fromHtml("&#x2713;"));
        } else {
            sakitperut.setText("x");
        }
        //9. sakitkepala
        if (gejala9 == 1) {
            sakitkepala.setText(Html.fromHtml("&#x2713;"));
        } else {
            sakitkepala.setText("x");
        }
        //10. kehilangan selera makan
        if (gejala10 == 1) {
            kehilanganseleramakan.setText(Html.fromHtml("&#x2713;"));
        } else {
            kehilanganseleramakan.setText("x");
        }
        //11. bab cair lebih dari 3x
        if (gejala11 == 1) {
            babcair.setText(Html.fromHtml("&#x2713;"));
        } else {
            babcair.setText("x");
        }
        //12. diare bercampur darah
        if (gejala12 == 1) {
            diarecampurdarah.setText(Html.fromHtml("&#x2713;"));
        } else {
            diarecampurdarah.setText("x");
        }
        //13. panas
        if (gejala13 == 1) {
            panas.setText(Html.fromHtml("&#x2713;"));
        } else {
            panas.setText("x");
        }
        //14. kelelahan
        if (gejala14 == 1) {
            kelelahan.setText(Html.fromHtml("&#x2713;"));
        } else {
            kelelahan.setText("x");
        }
        //15. perut keram
        if (gejala15 == 1) {
            perutkram.setText(Html.fromHtml("&#x2713;"));
        } else {
            perutkram.setText("x");
        }
        //16. penurunan bb
        if (gejala16 == 1) {
            penurunanbb.setText(Html.fromHtml("&#x2713;"));
        } else {
            penurunanbb.setText("x");
        }
        //17. sakitotot
        if (gejala17 == 1) {
            sakitotot.setText(Html.fromHtml("&#x2713;"));
        } else {
            sakitotot.setText("x");
        }
        //18. kulit kering
        if (gejala18 == 1) {
            kulitkering.setText(Html.fromHtml("&#x2713;"));
        } else {
            kulitkering.setText("x");
        }
        //19. tidak bab
        if (gejala19 == 1) {
            tidakbab.setText(Html.fromHtml("&#x2713;"));
        } else {
            tidakbab.setText("x");
        }
        //20. haus
        if (gejala20 == 1) {
            haus.setText(Html.fromHtml("&#x2713;"));
        } else {
            haus.setText("x");
        }
        //21. mata cekung
        if (gejala21 == 1) {
            matacekung.setText(Html.fromHtml("&#x2713;"));
        } else {
            matacekung.setText("x");
        }


        //untuk keracunana makanan
        double keracunanMakanan = 0;
        double diareTable = 0;
        double radangUsusTable = 0;
        double eColiTable = 0;
        double gastro = 0;
        double rota = 0;
        String solusi = "";

        if (gejala1 == 1) {
            keracunanMakanan += 1;
            diareTable += 1;
            radangUsusTable += 1;
            eColiTable += 1;
            gastro += 1;
            rota += 1;
        }

        if (gejala2 == 1) {
            keracunanMakanan += 1;
            diareTable += 1;
            radangUsusTable += 1;
        }

        if (gejala3 == 1) {
            keracunanMakanan += 1;
            radangUsusTable += 1;
        }

        if (gejala4 == 1) {
            keracunanMakanan += 1;
            eColiTable += 1;
        }

        if (gejala5 == 1) {
            keracunanMakanan += 1;
        }

        if (gejala6 == 1) {
            keracunanMakanan += 1;
        }

        if (gejala7 == 1) {
            keracunanMakanan += 1;
        }

        if (gejala8 == 1) {
            diareTable += 1;
            eColiTable += 1;
            gastro += 1;
        }

        if (gejala9 == 1) {
            diareTable += 1;
            gastro += 1;
        }

        if (gejala10 == 1) {
            diareTable += 1;
            gastro += 1;
        }

        if (gejala11 == 1) {
            diareTable += 1;
        }

        if (gejala12 == 1) {
            radangUsusTable += 1;
            eColiTable += 1;
            rota += 1;
        }

        if (gejala13 == 1) {
            radangUsusTable += 1;
            eColiTable += 1;
            gastro += 1;
        }

        if (gejala14 == 1) {
            eColiTable += 1;
            rota += 1;
        }

        if (gejala15 == 1) {
            eColiTable += 1;
        }

        if (gejala16 == 1) {
            gastro += 1;
        }

        if (gejala17 == 1) {
            gastro += 1;
        }

        if (gejala18 == 1) {
            rota += 1;
        }

        if (gejala19 == 1) {
            rota += 1;
        }

        if (gejala20 == 1) {
            rota += 1;
        }

        if (gejala21 == 1) {
            rota += 1;
        }
        if (keracunanMakanan == 7) {
            analisakeracunanmakanan.setText("positif");
            jumlahkeracunanmakanan.setText(String.format("%.0f", keracunanMakanan) + " dari " + "7");
            prosentasekeracunanmakanan.setText(String.format("%.2f", keracunanMakanan / 7 * 100) + "%");
            solusi_keracunan_makanan.setVisibility(View.VISIBLE);
        } else {
            analisakeracunanmakanan.setText("negatif");
            jumlahkeracunanmakanan.setText(String.format("%.0f", keracunanMakanan) + " dari " + "7");
            prosentasekeracunanmakanan.setText(String.format("%.2f", keracunanMakanan / 7 * 100) + "%");
            solusi_keracunan_makanan.setVisibility(View.GONE);
        }

        if (diareTable == 6) {
            analisadiare.setText("positif");
            jumlahdiare.setText(String.format("%.0f", diareTable) + " dari " + "6");
            prosentasediare.setText(String.format("%.2f", diareTable / 6 * 100) + "%");
            solusi_diare.setVisibility(View.VISIBLE);
        } else {
            analisadiare.setText("negatif");
            jumlahdiare.setText(String.format("%.0f", diareTable) + " dari " + "6");
            prosentasediare.setText(String.format("%.2f", diareTable / 6 * 100) + "%");
            solusi_diare.setVisibility(View.GONE);
        }

        if (radangUsusTable == 5) {
            analisaradangusus.setText("positif");
            jumlahradangusus.setText(String.format("%.0f", radangUsusTable) + " dari " + "5");
            prosentaseradangusus.setText(String.format("%.2f", radangUsusTable / 5 * 100) + "%");
            solusi_rading_usus.setVisibility(View.VISIBLE);
        } else {
            analisaradangusus.setText("negatif");
            jumlahradangusus.setText(String.format("%.0f", radangUsusTable) + " dari " + "5");
            prosentaseradangusus.setText(String.format("%.2f", radangUsusTable / 5 * 100) + "%");
            solusi_rading_usus.setVisibility(View.GONE);
        }

        if (eColiTable == 7) {
            analisecoli.setText("positif");
            jumlahecoli.setText(String.format("%.0f", eColiTable) + " dari " + "7");
            prosentaseecoli.setText(String.format("%.2f", eColiTable / 7 * 100) + "%");
            solusi_e_coli.setVisibility(View.VISIBLE);
        } else {
            analisecoli.setText("negatif");
            jumlahecoli.setText(String.format("%.0f", eColiTable) + " dari " + "7");
            prosentaseecoli.setText(String.format("%.2f", eColiTable / 7 * 100) + "%");
            solusi_e_coli.setVisibility(View.GONE);
        }

        if (gastro == 7) {
            analisagastro.setText("positif");
            jumlahgastro.setText(String.format("%.0f", gastro) + " dari " + "7");
            prosentasegastro.setText(String.format("%.2f", gastro / 7 * 100) + "%");
            solusi_gastro.setVisibility(View.VISIBLE);
        } else {
            analisagastro.setText("negatif");
            jumlahgastro.setText(String.format("%.0f", gastro) + " dari " + "7");
            prosentasegastro.setText(String.format("%.2f", gastro / 7 * 100) + "%");
            solusi_gastro.setVisibility(View.GONE);
        }

        if (rota == 7) {
            analisarota.setText("positif");
            jumlahrota.setText(String.format("%.0f", rota) + " dari " + "7");
            prosentaserota.setText(String.format("%.2f", rota / 7 * 100) + "%");
            solusi_rota.setVisibility(View.VISIBLE);
        } else {
            analisarota.setText("negatif");
            jumlahrota.setText(String.format("%.0f", rota) + " dari " + "7");
            prosentaserota.setText(String.format("%.2f", rota / 7 * 100) + "%");
            solusi_rota.setVisibility(View.GONE);
        }

//        solusiText.setText(solusi);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(Kesimpulan.this);
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
