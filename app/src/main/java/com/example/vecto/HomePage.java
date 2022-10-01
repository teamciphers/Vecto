package com.example.vecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    ImageView map_redirect, hambur;
    Button create_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ImageView map_redirect = (ImageView) findViewById(R.id.map_homepage);
        Button create_req = (Button) findViewById(R.id.btn_create_request);
        map_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
        create_req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateRequest();
            }
        });
        ImageView hambur = (ImageView) findViewById(R.id.hamburger);
        hambur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openup();
            }
        });



    }

    private void openup() {
        Intent profile = new Intent(this, update_profile.class);
        startActivity(profile);
    }

    private void openMap() {
        Intent map_open = new Intent(this, MapsActivity.class);
        startActivity(map_open);

    }

    private void openCreateRequest() {
        Intent create_request = new Intent(this, create_request.class);
        startActivity(create_request);

    }
}