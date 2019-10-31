package com.example.myapplication.licenseplatesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class insertcardata extends AppCompatActivity {

    EditText txtName, txtLicensePlate, txtState;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertcardata);
        txtName = (EditText)findViewById(R.id.txtName);
        txtLicensePlate = (EditText)findViewById(R.id.txtLicensePlate);
        txtState = (EditText)findViewById(R.id.txtState);


    }
}
