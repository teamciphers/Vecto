package com.example.vecto;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;



public class LoginPage extends AppCompatActivity {
    private TextView su;
    private Button log_in;
    EditText emailEditText, passwordEditText;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        su =(TextView) findViewById(R.id.opensignup);
        log_in = (Button) findViewById(R.id.login);

        emailEditText = findViewById(R.id.username_input);
        passwordEditText = findViewById(R.id.password_input);


        mAuth = FirebaseAuth.getInstance();




        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        log_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String pass = passwordEditText.getText().toString();
                String email = emailEditText.getText().toString().toLowerCase();
                if (email.isEmpty()) {
                    emailEditText.setError("Please enter email id");
                    emailEditText.requestFocus();
                } else if (pass.isEmpty()) {
                    passwordEditText.setError("Please enter your password");
                    passwordEditText.requestFocus();
                }else{
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                openHomePage();
                                Toast.makeText(LoginPage.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginPage.this, "Error!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    private void openSignup() {
        Intent i = new Intent(LoginPage.this, signup.class);
        startActivity(i);
    }

    private void openHomePage() {
        Intent j = new Intent(LoginPage.this, HomePage.class);
        startActivity(j);
    }

}