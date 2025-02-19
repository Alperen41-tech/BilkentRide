package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.UserGet;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityAccountSettingsPageBinding;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class AccountSettingsPage extends AppCompatActivity {


    private ActivityAccountSettingsPageBinding binding;
    private String curr_user_ID;
    private FirebaseAuth my_auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountSettingsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        my_auth = FirebaseAuth.getInstance();

        curr_user_ID = my_auth.getUid();

        Utilities.getUserWithId(curr_user_ID, new UserGet() {
            @Override
            public void onGet(User user) {
                binding.nameSurname.setText(user.getUserName() + "\n" + user.getUserSurname());
                binding.biography.setText(user.getDepartment() + "\n" + user.getBiography());
                binding.emailShow.setText(user.getEmail());

                Picasso.get().load(user.getUserPhotoUrl()).into(binding.userPhoto);
            }
        });

    }

    public void editProfileButtonClicked(View view)
    {

        Intent intent = new Intent(this, EditProfilePage.class);
        startActivity(intent);

    }

    public void passwordButtonClicked(View view)
    {
        Intent intent = new Intent(this, SecurityPage.class);
        startActivity(intent);
    }

    public void preferencesButtonClicked(View view)
    {
        //TODO creating the activvity of preferences and establisheing a patheay to go through over here
    }

    public void logOutButtonClicked(View view)
    {
        my_auth.signOut();

        Intent intent = new Intent(AccountSettingsPage.this, MainActivity.class);
        startActivity(intent);
        finish();
        Utilities.showToast(this,"Signed Out");
    }

    public void chatButtonClicked(View view)
    {
        Intent intent = new Intent(this, ChatsPage.class);
        startActivity(intent);
        finish();
    }

    public void mainPageButtonClicked(View view)
    {
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }

    public void goingMainPageButtonClicked(View view){
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }


}