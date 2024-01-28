package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.databinding.ActivityFindingRingAndRidePageBinding;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class FindingRingAndRidePage extends AppCompatActivity {



    private ActivityFindingRingAndRidePageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindingRingAndRidePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public void makeRideButtonClicked(View view)
    {

    }

    public void findMeRideButtonClicked(View view)
    {

    }

    public void tellMeRingOptionButtonClicked(View view)
    {




    }

    public void chatButton1Clicked(View view)
    {
        Intent intent = new Intent(FindingRingAndRidePage.this, ChatsPage.class);
        startActivity(intent);
    }

    public void profileButton5Clicked(View view)
    {

        Intent intent = new Intent(FindingRingAndRidePage.this, AccountSettingsPage.class);
        startActivity(intent);

    }



}