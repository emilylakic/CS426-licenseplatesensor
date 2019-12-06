package com.example.myapplication.licenseplatesensor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

class DataBaseInstance {

    private static DataBaseInstance mInstance;
    public DatabaseReference database;
    public static DatabaseReference myRef;

    //Database Instance from Firebase Console
    private DataBaseInstance() {
        database = FirebaseDatabase.getInstance().getReference();
        //myRef = database.getReference("Member");
    }

    //Get Instance function
    static DataBaseInstance getInstance()
    {
        if(mInstance == null)
        {
            mInstance = new DataBaseInstance();
        }

        return mInstance;
    }
}
