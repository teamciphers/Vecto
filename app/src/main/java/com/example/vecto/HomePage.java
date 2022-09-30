package com.example.vecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    ImageView map_redirect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ImageView map_redirect = (ImageView) findViewById(R.id.map_homepage);
        map_redirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


    }

    private void openMap() {
        Intent map_open = new Intent(this, MapsActivity.class);
        startActivity(map_open);

    }
}