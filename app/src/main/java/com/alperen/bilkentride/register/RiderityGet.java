package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Ride;
import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityDepartmentGetBinding;
import com.alperen.bilkentride.databinding.ActivityRiderityGetBinding;

import okhttp3.internal.Util;

public class RiderityGet extends AppCompatActivity {

    private ActivityRiderityGetBinding binding;

    private User current_user;
    private User new_user;

    private GradientDrawable gradientDrawable_bold;
    private GradientDrawable gradientDrawable_normal;

    private boolean yes;

    private boolean isSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiderityGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.ifRiderBox.setVisibility(View.INVISIBLE);



        Intent intent = getIntent();
        current_user = (User) intent.getSerializableExtra("current_user");
        new_user = new User();
        new_user.setNewUser(current_user);

        isSelected = false;
        yes = false;


        gradientDrawable_bold = new GradientDrawable();
        gradientDrawable_bold.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_bold.setColor(Color.WHITE); // Set the background color (in this case, red)
        gradientDrawable_bold.setCornerRadius(40);
        gradientDrawable_bold.setStroke(10, Color.BLACK); // Set the border size (2px) and color (black)


        gradientDrawable_normal = new GradientDrawable();
        gradientDrawable_normal.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_normal.setColor(Color.WHITE); // Set the background color (in this case, red)
        gradientDrawable_normal.setCornerRadius(40);
        gradientDrawable_normal.setStroke(0, Color.WHITE);


    }


    public void yesButtonClicked(View view){

        binding.yesButton.setBackground(gradientDrawable_bold);
        binding.noButton.setBackground(gradientDrawable_normal);

        binding.ifRiderBox.setVisibility(View.VISIBLE);

        isSelected = true;
        yes = true;

    }

    public void noButtonClicked(View view){

        binding.yesButton.setBackground(gradientDrawable_normal);
        binding.noButton.setBackground(gradientDrawable_bold);

        binding.ifRiderBox.setVisibility(View.INVISIBLE);

        isSelected = true;
        yes = false;

    }


    public void confirmRiderityButtonClicked(View view){

        if (isSelected){

            if (yes){

                if (binding.ifRiderBox.isChecked()){

                    new_user.setRider(true);
                    Intent intent = new Intent(RiderityGet.this, PasswordGet.class);
                    intent.putExtra("current_user", new_user);
                    startActivity(intent);
                    finish();

                }
                else{
                    Utilities.showToast(RiderityGet.this, "Please approve you have driver lisence");
                }


            }
            else{
                new_user.setRider(false);
                Intent intent = new Intent(RiderityGet.this, PasswordGet.class);
                intent.putExtra("current_user", new_user);
                startActivity(intent);
                finish();
            }




        }
        else{
            Utilities.showToast(RiderityGet.this, "Select one of the options above");
        }








    }



}