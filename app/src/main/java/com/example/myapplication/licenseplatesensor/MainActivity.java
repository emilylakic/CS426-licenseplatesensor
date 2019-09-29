package com.example.myapplication.licenseplatesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView displayAnswer;
    boolean carApproaches;
    ImageView carDisplay;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayAnswer = findViewById(R.id.carDetection);
        carDisplay = findViewById(R.id.car);

        if (!carApproaches) {
            displayAnswer.setText("NO CAR DETECTED");
            carDisplay.setVisibility(View.GONE);
        }
        else {
            displayAnswer.setText("CAR DETECTED");
            carDisplay.setVisibility(View.VISIBLE);
        }
    }
}

