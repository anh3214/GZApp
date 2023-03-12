package com.example.gztruyen.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gztruyen.CommonUltil.StaticCode;
import com.example.gztruyen.Home;
import com.example.gztruyen.R;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private Button btnLogin;
    private Button btnRegister;
    private FirebaseAuth mAuth;

    public void bindingView() {
        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    public void bindingAction() {
        btnLogin.setOnClickListener(this::btnLoginClick);
        btnRegister.setOnClickListener(this::btnRegisterClick);
    }

    private void btnRegisterClick(View view) {
        Intent it = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(it);
    }

    private void btnLoginClick(View view) {
        try{
            mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, Home.class);
                            startActivity(intent);
                            SharedPreferences pref = getApplicationContext().getSharedPreferences(StaticCode.PREF, Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString(StaticCode.TOKEN, task.getResult().toString());
                            editor.putString(StaticCode.USERNAME, username.getText().toString());
                            editor.apply();
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        }catch (Exception e){
            Toast.makeText(LoginActivity.this,"Login failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindingView();
        bindingAction();
    }
}