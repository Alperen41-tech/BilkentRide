package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.alperen.bilkentride.register.BirthdayGet;
import com.alperen.bilkentride.register.DepartmentGet;
import com.alperen.bilkentride.register.EmailGet;
import com.alperen.bilkentride.register.ForgotPassword;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {







    private ActivityMainBinding binding;


    private FirebaseAuth my_auth;

    private static SharedPreferences sharing;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Utilities.animate_car(this, binding.mainGround);

        my_auth = FirebaseAuth.getInstance();

        sharing = MainActivity.this.getSharedPreferences("com.alperen.bilkentride", MODE_PRIVATE);

        boolean remembered = sharing.getBoolean("isRemembered", false);
        boolean hasRide = sharing.getBoolean("hasRide", false);

        FirebaseUser user = my_auth.getCurrentUser();



        if (remembered && user != null && hasRide){
            Intent intent = new Intent(MainActivity.this, WaitingRoomPage.class);
            startActivity(intent);
            finish();
        }

        else if (remembered && user != null && !hasRide){
            Intent intent = new Intent(MainActivity.this, FindingRingAndRidePage.class);
            startActivity(intent);
            finish();
        }

        else if (!remembered && user != null && hasRide){
            Intent intent = new Intent(MainActivity.this, WaitingRoomPage.class);
            startActivity(intent);
            finish();
        }



    }

    public void signInButtonClicked(View view){

        String email = binding.emailInputText4.getText().toString();
        String password = binding.passwordInputText4.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Utilities.showToast(this, "Please enter both email and password");
        }

        else{
            my_auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Utilities.showToast(MainActivity.this, "Signed In");

                    SharedPreferences sharing_2 = MainActivity.this.getSharedPreferences("com.alperen.bilkentride",
                            MODE_PRIVATE);

                    sharing_2.edit().putBoolean("isRemembered", binding.ifRememberBox.isChecked()).apply();



                    Intent intent = new Intent(MainActivity.this, FindingRingAndRidePage.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(MainActivity.this, e.getLocalizedMessage());
                }
            });
        }


    }



    public void signUpTextClicked(View view){

        Intent intent = new Intent(this, EmailGet.class);
        startActivity(intent);
        finish();

    }

    public void forgotPasswordTextClicked(View view){

        Intent intent = new Intent(this, ForgotPassword.class);
        startActivity(intent);
    }


    public static SharedPreferences getSharing(){
        return sharing;
    }
}
