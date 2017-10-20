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

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.re_password)
    EditText re_password;
    @BindView(R.id.login_text)
    TextView login_text;
    @BindView(R.id.register_btn)
    AppCompatButton register_btn;
    private DBDataSource dataSource;
    private final String TAG = this.getClass().getSimpleName();
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.app_preferences), Context.MODE_PRIVATE);
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });
        dataSource = new DBDataSource(this);
        dataSource.open();
    }

    @OnClick(R.id.register_btn)
    public void registerNew() {
        String un = username.getText().toString();
        String pwd = password.getText().toString();
        String re_pass = re_password.getText().toString();

        if (un.equals("")) {
            Toast.makeText(getApplicationContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (pwd.equals("")) {
            Toast.makeText(getApplicationContext(), "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (re_pass.equals("")) {
            Toast.makeText(getApplicationContext(), "Re password tidak boleh kosong", Toast.LENGTH_SHORT).show();
        } else if (!pwd.equals(re_pass)) {
            Toast.makeText(getApplicationContext(), "Password dan Re password tidak sama", Toast.LENGTH_SHORT).show();
        } else {
            ArrayList<User> users = dataSource.getUser(un);
            if (users.size() > 0) {
                Toast.makeText(getApplicationContext(), "Username sudah dipakai, silahkan pilih lainnya", Toast.LENGTH_SHORT).show();
            } else {
                User user = null;
                user = dataSource.createUser(un, pwd);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", user.getUsername());
                editor.commit();
                startActivity(new Intent(this, Dashboard.class));
            }
        }
    }
}
