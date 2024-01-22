package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityDepartmentGetBinding;
import com.alperen.bilkentride.databinding.ActivityRiderityGetBinding;

public class RiderityGet extends AppCompatActivity {

    private ActivityRiderityGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiderityGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




    }



    public void goingBack_Dep(View view){


    }


    public void yesButtonClicked(){


    }

    public void noButtonClicked(View view){


    }


    public void confirmRiderityButtonClicked(View view){



    }



}