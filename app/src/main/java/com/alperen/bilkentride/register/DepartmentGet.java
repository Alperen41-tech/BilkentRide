package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityDepartmentGetBinding;

import java.util.ArrayList;

public class DepartmentGet extends AppCompatActivity {

    private ActivityDepartmentGetBinding binding;

    private User current_user;
    private User new_user;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();

        current_user = (User) intent.getSerializableExtra("current_user");
        new_user = new User();

        new_user.setNewUser(current_user);


        ArrayList<String> years = new ArrayList<>();
        years.add("P");
        for (int i = 1; i <= 4; i++){
            years.add("" + i);
        }
        years.add("G");

        String[] elements = getResources().getStringArray(R.array.spinner_elements);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, R.layout.custom_spinner_element, elements);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);





        Spinner spinner = binding.yearList;
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                new_user.setGradYear(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Utilities.showToast(DepartmentGet.this, "Please select your year at university");
            }
        });

        Spinner spinner_dep = binding.departmentList;
        spinner_dep.setAdapter(adapter1);

        spinner_dep.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                new_user.setDepartment(selectedItem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Utilities.showToast(DepartmentGet.this, "Please select your year at university");
            }
        });



    }




    public void confirmDepButtonClicked(View view){

        Intent intent = new Intent(DepartmentGet.this, RiderityGet.class);
        intent.putExtra("current_user", new_user);
        startActivity(intent);
        finish();

    }

    public void goingBack_Birthday(View view){

        Intent intent = new Intent(this, BirthdayGet.class);
        startActivity(intent);
        finish();

    }



}