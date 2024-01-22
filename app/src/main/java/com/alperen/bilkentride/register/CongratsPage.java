package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityBirthdayGetBinding;
import com.alperen.bilkentride.databinding.ActivityCongratsPageBinding;

public class CongratsPage extends AppCompatActivity {

    private ActivityCongratsPageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCongratsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }





    public void goToMainPageButtonClicked(View view){

    }
}