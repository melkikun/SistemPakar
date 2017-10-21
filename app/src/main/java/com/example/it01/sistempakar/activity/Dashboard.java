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
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.grid_view)
    GridView grid_view;
    SharedPreferences sharedPreferences;
    SharedPreferences sharedPreferences2;
    private final String TAG = getClass().getSimpleName();
    private int key = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DashBoard");
        sharedPreferences = getSharedPreferences(getResources().getString(R.string.app_preferences), Context.MODE_PRIVATE);
        sharedPreferences2 = getSharedPreferences(getResources().getString(R.string.app_pertanyaan), Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("username")) {
            startActivity(new Intent(this, Login.class));
        }
        List<Integer> x = new ArrayList<>();
        x.add(R.drawable.diagnose);
        x.add(R.drawable.petunjuk);
        x.add(R.drawable.user);
        x.add(R.drawable.history);
        x.add(R.drawable.logout);
        List<String> y = new ArrayList<>();
        y.add("Diagnosa");
        y.add("Petunjuk");
        y.add("Tentang");
        y.add("History");
        y.add("Logout");
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getApplicationContext(), x, y);
        grid_view.setAdapter(mainMenuAdapter);
        grid_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);

                        builder.setTitle("Konsultasi");
                        builder.setMessage("Apa anda yakin?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                sharedPreferences2.edit().clear().commit();
                                dialog.dismiss();
                                startActivity(new Intent(getApplicationContext(), G01.class));
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
                    case 1:
                        startActivity(new Intent(getApplicationContext(), Petunjuk.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        break;
                    case 3:
                        break;
                    case 4:
                        logOut();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void backToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(key == 1){
            key =0;
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "press back Button again to exit", Toast.LENGTH_SHORT).show();
            key++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav__menu, menu);
        MenuItem item = menu.getItem(0);
        String un = sharedPreferences.getString("username", null);
        item.setTitle(un);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                logOut();
                break;
            default:
                break;
        }
        return true;
    }

    public void logOut() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.commit();
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }
}





