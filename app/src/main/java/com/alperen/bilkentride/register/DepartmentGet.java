package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityDepartmentGetBinding;

public class DepartmentGet extends AppCompatActivity {

    private ActivityDepartmentGetBinding binding;

    private User current_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();

        current_user = (User) intent.getSerializableExtra("current_user");
        System.out.println(current_user);
        



    }


    public void goingBack_Birthday(View view){


    }

    public void confirmDepButtonClicked(View view){



    }



}