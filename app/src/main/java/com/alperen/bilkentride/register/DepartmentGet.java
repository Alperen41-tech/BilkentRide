package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityDepartmentGetBinding;

public class DepartmentGet extends AppCompatActivity {

    private ActivityDepartmentGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        



    }


    public void goingBack_Birthday(View view){


    }

    public void confirmDepButtonClicked(View view){



    }



}