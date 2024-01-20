package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.alperen.bilkentride.register.BirthdayGet;

public class MainActivity extends AppCompatActivity {




    private ActivityMainBinding binding;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent(MainActivity.this, BirthdayGet.class);
        startActivity(intent);
        finish();


    }









}