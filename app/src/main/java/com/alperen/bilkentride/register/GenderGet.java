package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityEmailGetBinding;
import com.alperen.bilkentride.databinding.ActivityGenderGetBinding;

public class GenderGet extends AppCompatActivity {


    private ActivityGenderGetBinding binding;
    private User current_user;
    private User new_user;

    private boolean isClicked;

    GradientDrawable gradientDrawable_bold;
    GradientDrawable gradientDrawable_normal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenderGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Utilities.animate_car(this, binding.genderGround);

        isClicked = false;

        Intent intent = getIntent();
        current_user = (User) intent.getSerializableExtra("current_user");

        new_user = new User();
        new_user.setNewUser(current_user);


        gradientDrawable_bold = new GradientDrawable();
        gradientDrawable_bold.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_bold.setColor(Color.WHITE); // Set the background color (in this case, red)
        gradientDrawable_bold.setCornerRadius(30);
        gradientDrawable_bold.setStroke(10, Color.parseColor("#99DC2323")); // Set the border size (2px) and color (black)


        gradientDrawable_normal = new GradientDrawable();
        gradientDrawable_normal.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_normal.setColor(Color.WHITE); // Set the background color (in this case, red)
        gradientDrawable_normal.setCornerRadius(10);
        gradientDrawable_normal.setStroke(0, Color.WHITE);

    }


    public void female_ButtonClicked(View view){
        new_user.setFemale(true);
        if (!isClicked){isClicked = true;}

        binding.maleButton.setBackground(gradientDrawable_normal);
        binding.femaleButton.setBackground(gradientDrawable_bold);


    }

    public void male_ButtonClicked(View view){
        new_user.setFemale(false);
        if (!isClicked){isClicked = true;}

        binding.maleButton.setBackground(gradientDrawable_bold);
        binding.femaleButton.setBackground(gradientDrawable_normal);
    }


    public void confirmGenderButtonClicked(View view){

        if (isClicked){
            Intent intent = new Intent(this, BirthdayGet.class);
            intent.putExtra("current_user", new_user);
            startActivity(intent);
        }
        else{
            Utilities.showToast(this,"Please select one of the options above");
        }



    }


    public void goingBack_Email(View view){
        Intent intent = new Intent(this, EmailGet.class);
        startActivity(intent);
        finish();
    }
}