package com.example.myapplication.licenseplatesensor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LoadImage extends AppCompatActivity {

    private static final String TAG = "LoadImage: ";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<PlateNumberModel> platesList;
    private PlateAdapter plateListAdapter;
    private DataBaseInstance mInstance;
    private Query registered_member;
    private ProgressBar progressBar;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);
        //Array list for license plates
        platesList = new ArrayList<>();
        //Must define button
        backButton = (Button) findViewById(R.id.backButton);

        //Adapter Setup
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.plateNumberList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        plateListAdapter = new PlateAdapter(platesList);
        recyclerView.setAdapter(plateListAdapter);
        mInstance = DataBaseInstance.getInstance();
        registered_member = mInstance.database.child("LoadImage");

        //Shows progress bar
        showProgressBar(true);

        //Takes user back to main screen of application
        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(LoadImage.this, insertcardata.class);

                startActivity(intent);
            }
        });

        //For a registered member, take data snapshot and references PlateNumberModel to add that specific model of vehicle
        registered_member.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                platesList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    PlateNumberModel model = snapshot.getValue(PlateNumberModel.class);
                    platesList.add(model);
                }

                plateListAdapter.notifyDataSetChanged();

                showProgressBar(false);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(LoadImage.this, databaseError.toString(), Toast.LENGTH_SHORT).show();
                showProgressBar(false);
            }
        });




    }
    //Shows Progress Bar method
    public void showProgressBar(boolean visibility){
        progressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}