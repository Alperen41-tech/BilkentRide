package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alperen.bilkentride.Classes.Ride;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityMakingRidePageBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import kotlinx.coroutines.flow.SharingCommand;
import okhttp3.internal.Util;

public class MakingRidePage extends AppCompatActivity {


    private ActivityMakingRidePageBinding binding;
    private String[] locations;
    private String whereFromLoc;
    private String whereToLoc;

    private FirebaseFirestore firestore;
    private FirebaseAuth my_auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMakingRidePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        whereFromLoc = "";
        whereToLoc = "";

        firestore = FirebaseFirestore.getInstance();
        my_auth = FirebaseAuth.getInstance();




        locations = getResources().getStringArray(R.array.locations);

        Spinner whereFrom = binding.whereFromSpinner;
        settingSpinner(whereFrom, locations);


        whereFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pt_loc = parent.getItemAtPosition(position).toString();

                if (!pt_loc.equals("Please Choose Location From the List below")){
                    whereFromLoc = pt_loc;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Utilities.showToast(MakingRidePage.this, "Please select one of the options");
            }
        });




        Spinner whereTo = binding.whereToSpinner;
        settingSpinner(whereTo, locations);

        whereTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String pt_loc = parent.getItemAtPosition(position).toString();

                if (!pt_loc.equals("Please Choose Location From the List below")){
                    whereToLoc = pt_loc;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Utilities.showToast(MakingRidePage.this, "Please select one of the options");
            }
        });

    }

    private void settingSpinner(Spinner spinner, String[] list){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void goingBack_MainPage(View view)
    {
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }



    public void mapButtonClicked(View view)
    {
        //TODO we need to have user open a map and choose location from here

    }

    public void letsFindTravellerButtonClicked(View view)
    {
        if (!whereFromLoc.isEmpty() && !whereToLoc.isEmpty()){

            Ride ride = new Ride();
            ride.setRiderId(my_auth.getUid());
            ride.setWhereFrom(whereFromLoc);
            ride.setWhereTo(whereToLoc);

            firestore.collection("Rides").document(my_auth.getUid()).set(ride).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                    MainActivity.getSharing().edit().putBoolean("hasRide", true).apply();


                    Intent intent = new Intent(MakingRidePage.this, WaitingRoomPage.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(MakingRidePage.this, e.getLocalizedMessage());
                }
            });
        }

        else{
            Utilities.showToast(this, "None of the Location infromation can be blank");
        }


        
    }

    public void chatButtonClicked(View view)
    {
        Intent intent = new Intent(this, ChatsPage.class);
        startActivity(intent);
        finish();
    }

    public void mainPageButtonClicked(View view)
    {
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }

    public void profileButtonClicked(View view)
    {
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();
    }
}