package com.example.it01.sistempakar.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.it01.sistempakar.R;
import com.example.it01.sistempakar.entities.User;
import com.example.it01.sistempakar.helper.DBDataSource;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_btn)
    AppCompatButton login_btn;
    @BindView(R.id.register_text)
    TextView register_text;
    SharedPreferences sharedPreferences;
    private DBDataSource dataSource;
    private final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_preferences), Context.MODE_PRIVATE);
        dataSource = new DBDataSource(this);
        dataSource.open();
    }

    @OnClick(R.id.login_btn)
    public void login() {
        String un = username.getText().toString();
        String pwd = password.getText().toString();
        if (!un.trim().equals("") && !pwd.trim().equals("")) {
            List<User> users = dataSource.loginUser(un, pwd);
            if (users.size() > 0) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", un);
                editor.putString("password", pwd);
                editor.commit();
                Intent intent = new Intent(this, Dashboard.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "username dan password tidak sesuai", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
