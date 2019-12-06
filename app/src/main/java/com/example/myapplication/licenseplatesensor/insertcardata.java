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

    //EditText field allows ability to change the parameters of the name, plate number, car color, and car model
    EditText txtName, plateNumber, carColor, carModel;
    //Saves user-inputted information
    Button btnSave;
    //Takes user to the next page if an unrecognized vehicle is suspected
    Button nextPage;
    //Two database references
    DatabaseReference reff;
    DatabaseReference reff2;
    //Reference to Member class
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Corresponding activity layout
        setContentView(R.layout.activity_insertcardata);
        //Must findViewById each object to be able to use them
        nextPage = (Button) findViewById(R.id.nextPage);
        txtName = (EditText)findViewById(R.id.txtName);
        plateNumber = (EditText)findViewById(R.id.plateNumber);
        carModel = (EditText)findViewById(R.id.carModel);
        carColor = (EditText)findViewById(R.id.carColor);
        btnSave = (Button)findViewById(R.id.btnSave);
        member = new Member();
        //Access child Member and under each unique key, access the key value pairs under that child in the database
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        //Access child Unrecognized and under each unique key, access the key value pairs under that child in the database
        reff2 = FirebaseDatabase.getInstance().getReference().child("Unrecognized");
        //Uses setter methods from Member class with values inputted by the user
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                member.setName(txtName.getText().toString().trim());
                member.setPlate(plateNumber.getText().toString().trim());
                member.setModel(carModel.getText().toString().trim());
                member.setColor(carColor.getText().toString().trim());
                reff.push().setValue(member);
                //Informs user a new member was added
                Toast.makeText(insertcardata.this, "New Member Added", Toast.LENGTH_LONG).show();
            }
        });
        //Navigates user to unrecognized vehicle screen (LoadImage class)
        nextPage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(insertcardata.this, LoadImage.class);
                startActivity(intent);
            }
        });
    }
}
