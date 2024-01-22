package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.alperen.bilkentride.register.BirthdayGet;
import com.alperen.bilkentride.register.DepartmentGet;

public class MainActivity extends AppCompatActivity {




    private ActivityMainBinding binding;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }

    public void signInButtonClicked(View view){


    }



    public void signUpTextClicked(View view){


    }

    public void forgotPasswordTextClicked(View view){

        System.out.println("hello");
    }















}