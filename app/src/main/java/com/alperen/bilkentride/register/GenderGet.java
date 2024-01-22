package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityEmailGetBinding;
import com.alperen.bilkentride.databinding.ActivityGenderGetBinding;

public class GenderGet extends AppCompatActivity {


    private ActivityGenderGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenderGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





    }


    public void female_ButtonClicked(View view){

    }

    public void male_ButtonClicked(View view){

    }


    public void confirmGenderButtonClicked(View view){

    }


    public void goingBack_Email(View view){

    }
}