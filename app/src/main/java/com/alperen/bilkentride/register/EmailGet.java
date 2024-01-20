package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alperen.bilkentride.databinding.ActivityEmailGetBinding;

public class EmailGet extends AppCompatActivity {



    private ActivityEmailGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.textView.setText("hello");



    }
}