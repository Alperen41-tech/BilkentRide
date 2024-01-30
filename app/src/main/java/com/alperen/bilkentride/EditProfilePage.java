package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.UserGet;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityEditProfilePageBinding;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

import okhttp3.internal.Util;

public class EditProfilePage extends AppCompatActivity {


    private ActivityEditProfilePageBinding binding;
    private boolean yes;
    private boolean isSelected;

    private boolean isPhotoUploaded;

    private FirebaseAuth my_auth;
    private FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfilePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ifRiderSetBox.setVisibility(View.INVISIBLE);

        my_auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();

        yes = false;
        isSelected = false;
        isPhotoUploaded = false;



        Utilities.getUserWithId(my_auth.getUid(), new UserGet() {
            @Override
            public void onGet(User user) {
                binding.nameAndSurnameText.setText(user.getUserName() + "\n" + user.getUserSurname());
                Picasso.get().load(user.getUserPhotoUrl()).into(binding.profilePhotoImage1);
                binding.editName.setHint(user.getUserName());
                binding.editSurname.setHint(user.getUserSurname());
                binding.editBiography.setHint(user.getBiography());
            }
        });

    }

    public void backButtonClicked(View view)
    {
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();
    }

    public void editProfilePhotoButtonClicked(View view)
    {

        //TODO take permission and new photo here


    }

    public void saveChangesButtonClicked(View view)
    {
        String name = binding.editName.getText().toString();
        String surname = binding.editSurname.getText().toString();
        String bio = binding.editBiography.getText().toString();

        if (name.isEmpty() && surname.isEmpty() && bio.isEmpty() && !isSelected && !isPhotoUploaded){
            Utilities.showToast(this, "Please enter some changes to set");
        }

        else{
            Utilities.getUserWithId(my_auth.getUid(), new UserGet() {
                @Override
                public void onGet(User user) {

                    if (!name.isEmpty()){
                        user.setUserName(name);
                    }
                    if (!surname.isEmpty()){
                        user.setUserSurname(surname);
                    }
                    if (!bio.isEmpty()){
                        user.setBiography(bio);
                    }

                    if (isSelected){
                        if (yes){
                            if (binding.ifRiderSetBox.isChecked()){
                                user.setRider(true);
                            }
                            else{
                                Utilities.showToast(EditProfilePage.this, "Please confirm that you have driver licence");
                            }
                        }
                        else{
                            user.setRider(false);
                        }
                    }

                    if (isPhotoUploaded){
                        //TODO update photo Id here
                    }




                    Utilities.updateUserWithID(EditProfilePage.this, my_auth.getUid(), user);

                    binding.nameAndSurnameText.setText(user.getUserName() + "\n" + user.getUserSurname());
                    Picasso.get().load(user.getUserPhotoUrl()).into(binding.profilePhotoImage1);
                    binding.editName.setHint(user.getUserName());
                    binding.editSurname.setHint(user.getUserSurname());
                    binding.editBiography.setHint(user.getBiography());

                    binding.editName.setText("");
                    binding.editSurname.setText("");
                    binding.editBiography.setText("");

                    
                }
            });
        }


    }

    public void yesClicked(View view){
        isSelected = true;
        yes = true;

        binding.ifRiderSetBox.setVisibility(View.VISIBLE);

        Utilities.makingNormalEdges(binding.noButton);
        Utilities.makingThickerEdges(binding.yesButton, 40, 10, Color.WHITE, Color.BLACK);

    }

    public void noClicked(View view){

        isSelected = true;
        yes = false;
        binding.ifRiderSetBox.setVisibility(View.INVISIBLE);
        Utilities.makingNormalEdges(binding.yesButton);
        Utilities.makingThickerEdges(binding.noButton, 40, 10, Color.WHITE, Color.BLACK);

    }





    public void chatButtonClicked(View view)
    {
        //TODO ask people if they really want to leave, info not saved
        Intent intent = new Intent(this, ChatsPage.class);
        startActivity(intent);
        finish();
    }

    public void mainPageButtonClicked(View view)
    {

        //TODO ask people if they really want to leave, info not saved
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }

    public void profileButtonClicked(View view)
    {
        //TODO ask people if they really want to leave, info not saved
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();

    }
}