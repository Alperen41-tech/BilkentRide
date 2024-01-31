package com.alperen.bilkentride.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.MainActivity;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityForgotPasswordBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import okhttp3.internal.Util;

public class ForgotPassword extends AppCompatActivity {

    private ActivityForgotPasswordBinding binding;
    private FirebaseAuth my_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForgotPasswordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        my_auth = FirebaseAuth.getInstance();

    }



    public void sendEmailButtonClicked(View view){

        String emailOfUser = binding.emailInputText3.getText().toString();

        if (!emailOfUser.isEmpty()){

            my_auth.sendPasswordResetEmail(emailOfUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Utilities.showToast(ForgotPassword.this, "Email Succesfully Sent Please Go to Website and Change Your Password and then sign in");
                    Intent intent = new Intent(ForgotPassword.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(ForgotPassword.this, e.getLocalizedMessage());
                }
            });

        }
        else{
            Utilities.showToast(this, "Please enter appropraite account email");
        }


    }

    public void backToMainClicked(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}