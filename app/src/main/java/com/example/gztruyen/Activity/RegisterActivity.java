package com.example.gztruyen.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.R;

public class RegisterActivity extends AppCompatActivity {

    private TextView fullnameuser;
    private TextView email;
    private TextView password;
    private TextView repassword;
    private Button btnsignup;

    public void bindingView(){
        fullnameuser = findViewById(R.id.fullnameuser);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        repassword = findViewById(R.id.repassword);
        btnsignup = findViewById(R.id.btnsignup);
    }
    public void bindingAction(){
        btnsignup.setOnClickListener(this::btnSignUpClick);
    }

    private void btnSignUpClick(View view) {
        Toast.makeText(this, "Register Susscessfuly", Toast.LENGTH_SHORT).show();
        Intent it = new Intent(this, LoginActivity.class);
        startActivity(it);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindingView();
        bindingAction();
    }
}