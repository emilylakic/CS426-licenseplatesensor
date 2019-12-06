package com.example.myapplication.licenseplatesensor;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class PermissionScreen extends AppCompatActivity {

    private ImageView image;
    private TextView plate_number,color,make,model;
    private ImageButton yes_button, no_button;
    DatabaseReference reff;
    private PlateNumberModel member;
    private static final String TAG = "PermissionScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Corresponding activity layout
        setContentView(R.layout.activity_permission_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Must findViewById each object to be able to use them
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        image = findViewById(R.id.image);
        plate_number = findViewById(R.id.plate_number);
        color = findViewById(R.id.color);
        make = findViewById(R.id.make);
        model = findViewById(R.id.model);
        yes_button = findViewById(R.id.yes_button);
        no_button = findViewById(R.id.no_button);

        //When user clicks the no button, the vehicle will be denied entry and that field will be deleted from the database
        no_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Toast.makeText(PermissionScreen.this, "Vehicle Denied Entry", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PermissionScreen.this, LoadImage.class);
                startActivity(intent);
            }
        });
        //Using setter methods to set the plate number, color, make, and model, represents the key value fields from the database
        plate_number.setText(Objects.requireNonNull(getIntent().getExtras()).getString("plates"));
        color.setText(getIntent().getExtras().getString("color"));
        make.setText(getIntent().getExtras().getString("make"));
        model.setText(getIntent().getExtras().getString("model"));
        //Obtain image through URL from the storage section of the database
        Glide.with(this).load(getIntent().getExtras().getString("URL")).into(image);

        //When user clicks the yes button, use setter methods to set value of the member along with their plate number, model, and car color in the database
        member = new PlateNumberModel();
        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //member.setName("Emily");
                member.setPlate(Objects.requireNonNull(getIntent().getExtras()).getString("plates"));
                member.setModel(getIntent().getExtras().getString("model"));
                member.setColor(getIntent().getExtras().getString("color"));
                reff.push().setValue(member);

                //Reference first database reference reff1
                DatabaseReference reff1 = FirebaseDatabase.getInstance().getReference();
                //Information obtained about the vehicle is placed in the LoadImage child of the database
                Query carsQuery = reff1.child("LoadImage").orderByChild("plate").equalTo(Objects.requireNonNull(getIntent().getExtras()).getString("plates"));
                //DataSnapshot instance contains data from Firebase Database location
                carsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Any time you read Database data, you receive the data as a DataSnapshot
                        for (DataSnapshot appleSnapshot: dataSnapshot.getChildren()) {
                            appleSnapshot.getRef().removeValue();
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled", databaseError.toException());
                    }
                });
                //Lets user know that the app registered their click on the yes button
                Toast.makeText(PermissionScreen.this, "Finish", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
