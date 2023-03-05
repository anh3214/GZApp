package com.example.gztruyen.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    private TextView fullnameuser;
    private TextView email;
    private TextView password;
    private TextView repassword;
    private Button btnsignup;
    private FirebaseAuth mAuth;

    public void bindingView(){
        mAuth = FirebaseAuth.getInstance();
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
        mAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Register Susscessfuly", Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(it);
                        }else{
                            Log.d("Debug","Create false");
                        }
                    }
                });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindingView();
        bindingAction();
    }
}