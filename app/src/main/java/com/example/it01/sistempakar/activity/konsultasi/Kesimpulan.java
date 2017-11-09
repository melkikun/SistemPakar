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

//class kesimpulan yang digunkan untuk menampilkan halaman kesimpulan
public class Kesimpulan extends AppCompatActivity {
    //shared preferences digunakan untuk menyimpan atau mengambil session
    SharedPreferences sharedPreferences;
    //inisialisasi toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    //inisialisasi list view untuk tambilan list penyakit/gejala
    @BindView(R.id.list_view)
    ListView list_view;
    //inisialisasi text view untuk tulisan kesimpulan akhir
    @BindView(R.id.kesimpulan_akhir)
    TextView kesimpulan_akhir;
    //hash map untuk menampung gejala penyakit sebanyak 20 gejala
    private HashMap<String, String> gejala;
    //list untuk menampung hasil dari penyakit yang di pilih pada nomer 1 sampai dengan 20
    private List<Integer> hasil;
    //inisialisasi string untuk menampung jenis penyakit apa yang diderita
    private String penyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //codingan bawaan android
        super.onCreate(savedInstanceState);
        //mengarahkan ke layout activity kesimpulan di res/layout/activity_kesimpulan.xml
        setContentView(R.layout.activity_kesimpulan);
        //butter knife untuk binding id dari xml
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
        int gejala1 = sharedPreferences.getInt("G01", 9999); //mengambil data dari gejala 1 berisi 0 atau 1(0 tidak, 1 ya)
        int gejala2 = sharedPreferences.getInt("G02", 9999);//mengambil data dari gejala 1 berisi 0 atau 2(0 tidak, 1 ya)
        int gejala3 = sharedPreferences.getInt("G03", 9999);//mengambil data dari gejala 1 berisi 0 atau 3(0 tidak, 1 ya)
        int gejala4 = sharedPreferences.getInt("G04", 9999);//mengambil data dari gejala 1 berisi 0 atau 4(0 tidak, 1 ya)
        int gejala5 = sharedPreferences.getInt("G05", 9999);//mengambil data dari gejala 1 berisi 0 atau 5(0 tidak, 1 ya)
        int gejala6 = sharedPreferences.getInt("G06", 9999);//mengambil data dari gejala 1 berisi 0 atau 6(0 tidak, 1 ya)
        int gejala7 = sharedPreferences.getInt("G07", 9999);//mengambil data dari gejala 1 berisi 0 atau 7(0 tidak, 1 ya)
        int gejala8 = sharedPreferences.getInt("G08", 9999);//mengambil data dari gejala 1 berisi 0 atau 8(0 tidak, 1 ya)
        int gejala9 = sharedPreferences.getInt("G09", 9999);//mengambil data dari gejala 1 berisi 0 atau 9(0 tidak, 1 ya)
        int gejala10 = sharedPreferences.getInt("G10", 9999);//mengambil data dari gejala 1 berisi 0 atau 10(0 tidak, 1 ya)
        int gejala11 = sharedPreferences.getInt("G11", 9999);//mengambil data dari gejala 1 berisi 0 atau 11(0 tidak, 1 ya)
        int gejala12 = sharedPreferences.getInt("G12", 9999);//mengambil data dari gejala 1 berisi 0 atau 12(0 tidak, 1 ya)
        int gejala13 = sharedPreferences.getInt("G13", 9999);//mengambil data dari gejala 1 berisi 0 atau 13(0 tidak, 1 ya)
        int gejala14 = sharedPreferences.getInt("G14", 9999);//mengambil data dari gejala 1 berisi 0 atau 14(0 tidak, 1 ya)
        int gejala15 = sharedPreferences.getInt("G15", 9999);//mengambil data dari gejala 1 berisi 0 atau 15(0 tidak, 1 ya)
        int gejala16 = sharedPreferences.getInt("G16", 9999);//mengambil data dari gejala 1 berisi 0 atau 16(0 tidak, 1 ya)
        int gejala17 = sharedPreferences.getInt("G17", 9999);//mengambil data dari gejala 1 berisi 0 atau 17(0 tidak, 1 ya)
        int gejala18 = sharedPreferences.getInt("G18", 9999);//mengambil data dari gejala 1 berisi 0 atau 18(0 tidak, 1 ya)
        int gejala19 = sharedPreferences.getInt("G19", 9999);//mengambil data dari gejala 1 berisi 0 atau 19(0 tidak, 1 ya)
        int gejala20 = sharedPreferences.getInt("G20", 9999);//mengambil data dari gejala 1 berisi 0 atau 20(0 tidak, 1 ya)

        //inisialisasi list yang ada pada baris 49 dijadikan array list
        hasil = new ArrayList<>();
        hasil.add(gejala1);//menampung variiabel gejala 1 ke dalam list
        hasil.add(gejala2);//menampung variiabel gejala 2 ke dalam list
        hasil.add(gejala3);//menampung variiabel gejala 3 ke dalam list
        hasil.add(gejala4);//menampung variiabel gejala 4 ke dalam list
        hasil.add(gejala5);//menampung variiabel gejala 5 ke dalam list
        hasil.add(gejala6);//menampung variiabel gejala 6 ke dalam list
        hasil.add(gejala7);//menampung variiabel gejala  7 ke dalam list
        hasil.add(gejala8);//menampung variiabel gejala 8 ke dalam list
        hasil.add(gejala9);//menampung variiabel gejala 9 ke dalam list
        hasil.add(gejala10);//menampung variiabel gejala 10 ke dalam list
        hasil.add(gejala11);//menampung variiabel gejala 11 ke dalam list
        hasil.add(gejala12);//menampung variiabel gejala 12 ke dalam list
        hasil.add(gejala13);//menampung variiabel gejala  13 ke dalam list
        hasil.add(gejala14);//menampung variiabel gejala 14 ke dalam list
        hasil.add(gejala15);//menampung variiabel gejala 15 ke dalam list
        hasil.add(gejala16);//menampung variiabel gejala 16 ke dalam list
        hasil.add(gejala17);//menampung variiabel gejala 17 ke dalam list
        hasil.add(gejala18);//menampung variiabel gejala 18 ke dalam list
        hasil.add(gejala19);//menampung variiabel gejala 19 ke dalam list
        hasil.add(gejala20);//menampung variiabel gejala 20 ke dalam list

        gejala = new HashMap<>(); //inisialisasi hash map berisi kode gejala dan nama gejala yang ada pada baris 49 dijadikan array list
        gejala.put("G1", "mual"); //kode gejala G1 bernama mual
        gejala.put("G2", "demam menggigil"); //sama seperti kode gejala G1
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

        //PENGECEKAN UTAMA DARI GEJALA YANG TELAH DI PILIH DARI PERTANYAAN 1 SAMPAI DENGAN 20 DAN HASILNYA AKAN DI TAMPUNG DI VARIABEL PENYAKIT
        //jika gejala 1 ya dan gejala 2 ya dan gejala 3 ya dan gejala 4 ya dan gejala 5 ya dan gejala 6 ya makan hasilnya addalah keracunan makanan
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
            //jika if mulai baris 146 sampai 156 tidak menghasilkan penyakit maka penyakitnya adalah tidak di temukan
        } else {
            penyakit = "Penyakit Tidak Ditemukan";
        }
        //mengambil data dari class adapter untuk di tampilkan berupa list / daftar penyakit (lihat class kesimpulan adapter)
        KesimpulanAdapter adapter = new KesimpulanAdapter(getApplicationContext(), gejala, hasil);
        //list view di set dengan adapter dari kesimpulan
        list_view.setAdapter(adapter);
        //mengganti text untuk kesimpulan sesuai hasil if pada baris 145 sampai 160
        kesimpulan_akhir.setText("Berdasarkan hasil analisa anda menderita penyakit : " + penyakit);
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
