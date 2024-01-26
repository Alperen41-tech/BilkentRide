package com.alperen.bilkentride.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.number.IntegerWidth;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.FindingRingAndRidePage;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityPasswordGetBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import kotlin.OverloadResolutionByLambdaReturnType;

public class PasswordGet extends AppCompatActivity {

    private ActivityPasswordGetBinding binding;


    private User current_user;
    private User new_user;

    FirebaseAuth my_auth;
    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasswordGetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Utilities.animate_car(this, binding.passwordGround);

        Intent intent = getIntent();

        current_user = (User) intent.getSerializableExtra("current_user");
        new_user = new User();
        new_user.setNewUser(current_user);

        my_auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();



    }



    public void confirmPasswordButtonClicked(View view){

        String email = binding.emailInputText.getText().toString();
        String password_1 = binding.passwordInputText1.getText().toString();
        String password_2 = binding.passwordInputText2.getText().toString();


        if (email.isEmpty() || password_1.isEmpty() || password_2.isEmpty()){
            Utilities.showToast(this, "None of the ınputs can be blank");
        }

        else{
            if (password_1.equals(password_2)) {
                new_user.setEmail(email);
                new_user.setUserPhotoUrl("https://firebasestorage.googleapis.com/v0/b/bilkenride-database.appspot.com/o/images%2Fperson_circle.png?alt=media&token=3d4d0df5-084a-4d1c-abde-aa228745732d");
                System.out.println(new_user);

                my_auth.createUserWithEmailAndPassword(new_user.getEmail(), password_1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        new_user.setId(my_auth.getUid());

                        firestore.collection("Users").document(new_user.getId()).set(new_user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Utilities.showToast(PasswordGet.this,"Profile successfully created and saved");
                                Intent intent = new Intent(PasswordGet.this, CongratsPage.class);
                                startActivity(intent);
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Utilities.showToast(PasswordGet.this, e.getLocalizedMessage());
                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utilities.showToast(PasswordGet.this, e.getLocalizedMessage());
                    }
                });

            }
            else{
                Utilities.showToast(this, "Passwords do not match");
            }
        }

    }



    public void goingBack_Rider(View view){


    }


}