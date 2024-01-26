package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityPasswordGetBinding;

public class PasswordGet extends AppCompatActivity {

    private ActivityPasswordGetBinding binding;


    private User current_user;
    private User new_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        current_user = (User) intent.getSerializableExtra("current_user");
        System.out.println(current_user);



    }



    public void goingBack_Rider(View view){


    }


    public void confirmPasswordButtonClicked(View view){


    }

}