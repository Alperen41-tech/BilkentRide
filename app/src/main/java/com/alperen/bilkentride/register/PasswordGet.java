package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityPasswordGetBinding;

public class PasswordGet extends AppCompatActivity {

    private ActivityPasswordGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }



    public void goingBack_Rider(View view){


    }


    public void confirmPasswordButtonClicked(View view){


    }

}