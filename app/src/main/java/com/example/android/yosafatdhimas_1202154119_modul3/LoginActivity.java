package com.example.android.yosafatdhimas_1202154119_modul3;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.edittext_username_login);
        password = (EditText) findViewById(R.id.edittext_pass_login);
        btn_login = (Button) findViewById(R.id.button_login);

        //menjalankan fungsi ketika button LOG IN diklik
        btn_login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String usernamekey = username.getText().toString();
                String passwordkey = password.getText().toString();

                if (usernamekey.equals("EAD") && passwordkey.equals("MOBILE")){
                    Toast.makeText(getApplicationContext(), "Login sukses, selamat datang EAD!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                } else {
                    //AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    //builder.setMessage("username atau password salah!").setNegativeButton("Retry",null).create().show();
                    Toast.makeText(getApplicationContext(), "Username atau Password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
