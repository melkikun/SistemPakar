package com.example.it01.sistempakar.activity.konsultasi;

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
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.activity.Dashboard;
import com.example.it01.sistempakar.adapter.KesimpulanAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Kesimpulan extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list_view)
    ListView list_view;
    @BindView(R.id.kesimpulan_akhir)
    TextView kesimpulan_akhir;
    private HashMap<String, String> gejala;
    private List<Integer> hasil;
    private String penyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesimpulan);
        ButterKnife.bind(this);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/delius_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Kesimpulan");

        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        int gejala1 = sharedPreferences.getInt("G01", 9999);
        int gejala2 = sharedPreferences.getInt("G02", 9999);
        int gejala3 = sharedPreferences.getInt("G03", 9999);
        int gejala4 = sharedPreferences.getInt("G04", 9999);
        int gejala5 = sharedPreferences.getInt("G05", 9999);
        int gejala6 = sharedPreferences.getInt("G06", 9999);
        int gejala7 = sharedPreferences.getInt("G07", 9999);
        int gejala8 = sharedPreferences.getInt("G08", 9999);
        int gejala9 = sharedPreferences.getInt("G09", 9999);
        int gejala10 = sharedPreferences.getInt("G10", 9999);
        int gejala11 = sharedPreferences.getInt("G11", 9999);
        int gejala12 = sharedPreferences.getInt("G12", 9999);
        int gejala13 = sharedPreferences.getInt("G13", 9999);
        int gejala14 = sharedPreferences.getInt("G14", 9999);
        int gejala15 = sharedPreferences.getInt("G15", 9999);
        int gejala16 = sharedPreferences.getInt("G16", 9999);
        int gejala17 = sharedPreferences.getInt("G17", 9999);
        int gejala18 = sharedPreferences.getInt("G18", 9999);
        int gejala19 = sharedPreferences.getInt("G19", 9999);
        int gejala20 = sharedPreferences.getInt("G20", 9999);

        hasil = new ArrayList<>();
        hasil.add(gejala1);
        hasil.add(gejala2);
        hasil.add(gejala3);
        hasil.add(gejala4);
        hasil.add(gejala5);
        hasil.add(gejala6);
        hasil.add(gejala7);
        hasil.add(gejala8);
        hasil.add(gejala9);
        hasil.add(gejala10);
        hasil.add(gejala11);
        hasil.add(gejala12);
        hasil.add(gejala13);
        hasil.add(gejala14);
        hasil.add(gejala15);
        hasil.add(gejala16);
        hasil.add(gejala17);
        hasil.add(gejala18);
        hasil.add(gejala19);
        hasil.add(gejala20);

        gejala = new HashMap<>();
        gejala.put("G1", "mual");
        gejala.put("G2", "demam menggigil");
        gejala.put("G3", "kehilangan selera makan");
        gejala.put("G4", "diare");
        gejala.put("G5", "mengalami kejang2");
        gejala.put("G6", "pandangan kabur");
        gejala.put("G7", "sakit perut");
        gejala.put("G8", "sakit kepala");
        gejala.put("G9", "pendarahan pada anus");
        gejala.put("G10", "penurunan berat badan");
        gejala.put("G11", "diare bercampur darah dan bersifat kambuhan");
        gejala.put("G12", "kelelahan");
        gejala.put("G13", "peru kram");
        gejala.put("G14", "demam diatas 40 derajat celcius");
        gejala.put("G15", "tidak buang air selama 12 jam atau lebih");
        gejala.put("G16", "selalu merasa haus berlebihan");
        gejala.put("G17", "mata menjadi cekung");
        gejala.put("G18", "kulit yang kering atau dingin");
        gejala.put("G19", "demam");
        gejala.put("G20", "sakit otot");

        if (gejala1 == 1 && gejala2 == 1 && gejala3 == 1 && gejala4 == 1 && gejala5 == 1 && gejala6 == 1) {
            penyakit = "Keracunan Makanan";
        } else if (gejala1 == 1 && gejala17 == 1 && gejala18 == 1 && gejala3 == 1 && gejala10 == 1 && gejala19 == 1) {
            penyakit = "Diare";
        } else if (gejala1 == 1 && gejala11 == 1 && gejala12 == 1) {
            penyakit = "Radang Usus";
        } else if (gejala1 == 1 && gejala11 == 1 && gejala12 == 1 && gejala13 == 1 && gejala19 == 1 && gejala14 == 1 && gejala17 == 1) {
            penyakit = "E.Coli";
        } else if (gejala1 == 1 && gejala17 == 1 && gejala18 == 1 && gejala3 == 1 && gejala10 == 1 && gejala14 == 1 && gejala20 == 1 && gejala18 == 1) {
            penyakit = "Gastro Entritis";
        } else if (gejala1 == 1 && gejala11 == 1 && gejala12 == 1 && gejala18 == 1 && gejala15 == 1 && gejala16 == 1 && gejala17 == 1 && gejala6 == 1) {
            penyakit = "Rotaviurus";
        }else {
            penyakit = "Penyakit Tidak Ditemukan";
        }

        KesimpulanAdapter adapter = new KesimpulanAdapter(getApplicationContext(), gejala, hasil);
        list_view.setAdapter(adapter);

        kesimpulan_akhir.setText("Berdasarkan hasil analisa anda menderita penyakit : " + penyakit);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(getApplicationContext(), G20.class));
                break;
            case R.id.utama:
                AlertDialog.Builder builder = new AlertDialog.Builder(Kesimpulan.this);

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
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.finsih_menu, menu);
        return true;
    }

}
