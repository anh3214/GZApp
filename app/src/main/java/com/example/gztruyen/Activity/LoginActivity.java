package com.example.gztruyen.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gztruyen.Home;
import com.example.gztruyen.MainActivity;
import com.example.gztruyen.R;
import com.example.gztruyen.adapters.ApiAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;
    private Button btnLogin;
    private Button btnRegister;
    private FirebaseAuth mAuth;
    public void bindingView(){
        mAuth = FirebaseAuth.getInstance();
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
        mAuth.signInWithEmailAndPassword(username.getText().toString(),password.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = mAuth.getCurrentUser();
                            user.getIdToken(true).addOnCompleteListener(idTokenTask -> {
                                if (idTokenTask.isSuccessful()) {
                                    mAuth.getCurrentUser().getIdToken(true)
                                            .addOnSuccessListener(result -> {
                                                String token = result.getToken();
                                                SharedPreferences mPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
                                                SharedPreferences.Editor prefsEditor = mPrefs.edit();
                                                prefsEditor.putString("token", token);
                                                prefsEditor.apply();
                                                ApiAdapter.mContext = LoginActivity.this;
                                                Intent intent = new Intent(LoginActivity.this,Home.class);
                                                startActivity(intent);
                                            })
                                            .addOnFailureListener(e -> {
                                                // Lấy token thất bại
                                            });
                                } else {
                                    Toast.makeText(LoginActivity.this, "Failed to get ID token", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindingView();
        bindingAction();
    }
}