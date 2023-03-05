package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gztruyen.Home;
import com.example.gztruyen.MainActivity;
import com.example.gztruyen.R;

public class LoginActivity extends AppCompatActivity {
private TextView username;
private TextView password;
private Button btnLogin;
private Button btnRegister;
public void bindingView(){
    username = findViewById(R.id.username);
    password = findViewById(R.id.password);
    btnLogin = findViewById(R.id.btnLogin);
    btnRegister = findViewById(R.id.btnRegister);
}
public void bindingAction(){
    btnLogin.setOnClickListener(this::btnLoginClick);
    btnRegister.setOnClickListener(this::btnRegisterClick);
}

    private void btnRegisterClick(View view) {
        Intent it = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(it);
    }

    private void btnLoginClick(View view) {

    if(username.getText().toString().equalsIgnoreCase("admin") &&
       password.getText().toString().equalsIgnoreCase("admin")){
        Intent i = new Intent(this, Home.class);
        startActivity(i);
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