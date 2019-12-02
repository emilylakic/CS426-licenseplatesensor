package com.example.myapplication.licenseplatesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class insertcardata extends AppCompatActivity {

    EditText txtName, plateNumber, carColor, carModel;
    Button btnSave;
    Button nextPage;
    DatabaseReference reff;
    DatabaseReference reff2;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertcardata);
        nextPage = (Button) findViewById(R.id.nextPage);
        txtName = (EditText)findViewById(R.id.txtName);
        plateNumber = (EditText)findViewById(R.id.plateNumber);
        carModel = (EditText)findViewById(R.id.carModel);
        carColor = (EditText)findViewById(R.id.carColor);
        btnSave = (Button)findViewById(R.id.btnSave);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff2 = FirebaseDatabase.getInstance().getReference().child("Unrecognized");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                member.setName(txtName.getText().toString().trim());
                member.setPlate(plateNumber.getText().toString().trim());
                member.setModel(carModel.getText().toString().trim());
                member.setColor(carColor.getText().toString().trim());
                reff.push().setValue(member);
                Toast.makeText(insertcardata.this, "New Member Added", Toast.LENGTH_LONG).show();
            }
        });
        nextPage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(insertcardata.this, LoadImage.class);

                startActivity(intent);
            }
        });
    }
}
