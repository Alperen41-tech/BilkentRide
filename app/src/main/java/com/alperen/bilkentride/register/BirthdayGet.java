package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityBirthdayGetBinding;
import com.alperen.bilkentride.databinding.ActivityGenderGetBinding;

public class BirthdayGet extends AppCompatActivity {
    private ActivityBirthdayGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBirthdayGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





    }


    public void confirmBirthdayButtonClicked(View view){

    }

    public void goingBack_Gender(View view){


    }




}