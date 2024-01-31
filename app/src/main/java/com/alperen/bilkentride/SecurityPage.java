package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.UserGet;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.alperen.bilkentride.databinding.ActivitySecurityPageBinding;
import com.alperen.bilkentride.register.ForgotPassword;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import okhttp3.internal.Util;

public class SecurityPage extends AppCompatActivity {


    private ActivitySecurityPageBinding binding;

    private FirebaseAuth my_auth;
    private FirebaseUser curr_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecurityPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        my_auth = FirebaseAuth.getInstance();
        curr_user = my_auth.getCurrentUser();

        Utilities.getUserWithId(my_auth.getUid(), new UserGet() {
            @Override
            public void onGet(User user) {
                binding.textView13.setText(user.getUserName());
            }
        });



    }

    public void forgotPasswordClicked(View view){
        Intent intent = new Intent(SecurityPage.this, ForgotPassword.class);
        startActivity(intent);
        finish();
        my_auth.signOut();
    }


    public void backButtonClicked(View view)
    {
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();
    }

    public void saveNewPasswordButtonClicked(View view)
    {
        String email = curr_user.getEmail();
        String passwword = binding.currentPasswordEditText.getText().toString();

        if (!passwword.isEmpty()){
            AuthCredential credential = EmailAuthProvider.getCredential(email, passwword);

            curr_user.reauthenticate(credential).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {

                    String password_1 = binding.newPasswordeditText.getText().toString();
                    String password_2 = binding.newPasswordAgainEditText.getText().toString();

                    if (!password_1.isEmpty() && !password_2.isEmpty()){
                        if (password_1.equals(password_2)){
                            curr_user.updatePassword(password_1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Utilities.showToast(SecurityPage.this, "Your password has been successfully changed!");
                                    Intent intent = new Intent(SecurityPage.this, AccountSettingsPage.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Utilities.showToast(SecurityPage.this, e.getLocalizedMessage());
                                }
                            });
                        }
                    }
                    else{
                        Utilities.showToast(SecurityPage.this, "Please enter the password that you want to sign in");
                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(SecurityPage.this, "Provided current password seems wrong please try again, if you do not remember click Forgot Password Page but you will need to sign in again with you new password");
                }
            });
        }
        else{
            Utilities.showToast(this, "Please enter your current password");
        }




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

    public void profileButtonClicked(View view)
    {
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();
    }
}