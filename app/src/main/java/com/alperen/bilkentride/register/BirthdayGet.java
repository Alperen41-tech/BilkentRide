package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityBirthdayGetBinding;
import com.alperen.bilkentride.databinding.ActivityGenderGetBinding;

import java.util.Calendar;

public class BirthdayGet extends AppCompatActivity {
    private ActivityBirthdayGetBinding binding;


    private User current_user;
    private User new_user;

    private int curr_day;
    private int curr_month;
    private int curr_year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBirthdayGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Utilities.animate_car(this, binding.birthdayGround);


        new_user = new User();


        curr_year = 0;
        curr_day = 0;
        curr_month = 0;

        Intent intent = getIntent();
        current_user = (User) intent.getSerializableExtra("current_user");
        new_user.setNewUser(current_user);

        TextView birth = binding.birthDayText;

        birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


    }





    public void confirmBirthdayButtonClicked(View view){


        if (curr_day == 0 || curr_month == 0 || curr_year == 0){
            Utilities.showToast(this, "Please select your birthday properly");
        }

        else{

            new_user.setBirthDay(curr_day);
            new_user.setBirthMonth(curr_month);
            new_user.setBirthYear(curr_year);

            Intent intent = new Intent(this, DepartmentGet.class);
            intent.putExtra("current_user", new_user);
            startActivity(intent);
            finish();
        }
    }

    public void goingBack_Gender(View view){

        Intent intent = new Intent(this, GenderGet.class);
        startActivity(intent);
        finish();

    }


    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        binding.birthDayText.setText(selectedDate);
                        curr_year = year;
                        curr_month = month + 1;
                        curr_day = dayOfMonth;

                    }
                },
                // Set default date to current date minus 18 years (as an example)
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        // Set the maximum date to the current date minus 18 years
        datePickerDialog.getDatePicker().setMaxDate(Calendar.getInstance().getTimeInMillis());
        datePickerDialog.show();
    }




}