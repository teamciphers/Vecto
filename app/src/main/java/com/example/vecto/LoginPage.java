package com.example.vecto;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


public class LoginPage extends AppCompatActivity {
    private TextView su;
    private Button log_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        su =(TextView) findViewById(R.id.opensignup);
        log_in = (Button) findViewById(R.id.login);



        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomePage();
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