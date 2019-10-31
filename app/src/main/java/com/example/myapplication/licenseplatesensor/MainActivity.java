package com.example.myapplication.licenseplatesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    TextView displayAnswer;
    boolean carApproaches;
    ImageView carDisplay;
    //Socket myAppSocket = null;
   // public static String wifiModuleIp = "";
   // public static int wifiModulePort = 0;
    //public static String CMD = "0";

    @SuppressLint("SetTextI18n")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this, "Firebase Connection Success", Toast.LENGTH_LONG).show();

       // approve = (Button) findViewById(R.id.approve);
       // deny = (Button) findViewById(R.id.deny);

       /// ipAddress = (EditText) findViewById(R.id.ipAddress);

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



