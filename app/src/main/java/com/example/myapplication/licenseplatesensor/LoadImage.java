package com.example.myapplication.licenseplatesensor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        platesList = new ArrayList<>();
        backButton = (Button) findViewById(R.id.backButton);
        //Adapter setup
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.plateNumberList);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        plateListAdapter = new PlateAdapter(platesList);
        recyclerView.setAdapter(plateListAdapter);
        mInstance = DataBaseInstance.getInstance();
        registered_member = mInstance.database.child("LoadImage");

        showProgressBar(true);

        backButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(LoadImage.this, insertcardata.class);

                startActivity(intent);
            }
        });

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

    public void showProgressBar(boolean visibility){
        progressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }
}