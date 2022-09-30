package com.example.vecto;

import android.os.Bundle;
import android.content.Intent;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class signup extends AppCompatActivity {


    private Button su;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        su = (Button) findViewById(R.id.btn_homepage);

        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openhomepage();
            }


        });
    }
        private void openhomepage() {
            Intent i = new Intent(signup.this, HomePage.class);
            startActivity(i);
        }
}