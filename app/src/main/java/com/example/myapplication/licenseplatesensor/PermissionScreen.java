package com.example.myapplication.licenseplatesensor;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class PermissionScreen extends AppCompatActivity {

    private ImageView image;
    private TextView plate_number,color,make,model;
    private ImageButton yes_button, no_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        image = findViewById(R.id.image);
        plate_number = findViewById(R.id.plate_number);
        color = findViewById(R.id.color);
        make = findViewById(R.id.make);
        model = findViewById(R.id.model);

        yes_button = findViewById(R.id.yes_button);
        no_button = findViewById(R.id.no_button);


        plate_number.setText(Objects.requireNonNull(getIntent().getExtras()).getString("plates"));
        color.setText(getIntent().getExtras().getString("color"));
        make.setText(getIntent().getExtras().getString("make"));
        model.setText(getIntent().getExtras().getString("model"));
        Glide.with(this).load(getIntent().getExtras().getString("URL")).into(image);


        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
