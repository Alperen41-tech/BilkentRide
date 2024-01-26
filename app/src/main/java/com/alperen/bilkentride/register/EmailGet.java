package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.MainActivity;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityEmailGetBinding;

import java.util.ArrayList;

public class EmailGet extends AppCompatActivity {



    private ActivityEmailGetBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmailGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Utilities.animate_car(this, binding.emailGround);


    }







    public void confirmEmailButtonClicked(View view){

        String name = binding.nameInputText.getText().toString();
        String surname = binding.surnameInputText.getText().toString();




        if (name.isEmpty() || surname.isEmpty()){
            Utilities.showToast(this, "None of those area can be blank");
        }

        else{

            name.trim();
            surname.trim();

            name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
            surname = surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase();


            User user = new User();
            user.setUserName(name);
            user.setUserSurname(surname);


            Intent intent = new Intent(this, GenderGet.class);
            intent.putExtra("current_user", user);
            startActivity(intent);
            finish();
        }
    }

    public void goingBack_SignIn(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }








}