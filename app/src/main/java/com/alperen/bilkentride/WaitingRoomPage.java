package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityMakingRidePageBinding;
import com.alperen.bilkentride.databinding.ActivityWaitingRoomPageBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class WaitingRoomPage extends AppCompatActivity {



    private ActivityWaitingRoomPageBinding binding;
    String time_remaining;


    private FirebaseFirestore firestore;
    private FirebaseAuth my_auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaitingRoomPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();
        my_auth = FirebaseAuth.getInstance();


        new CountDownTimer(600000, 1000 ){

            @Override
            public void onTick(long millisUntilFinished) {

                int min = (int) (millisUntilFinished / 60000);

                time_remaining = "Remaining time: " + min  +" min " +  (millisUntilFinished % 60000)/1000 + " sec";
                binding.remainingTimeText.setText(time_remaining);
            }

            @Override
            public void onFinish() {

                firestore.collection("Rides").document(my_auth.getUid()).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Utilities.showToast(WaitingRoomPage.this, "Your ride has been cancelled due to time");
                        Intent intent = new Intent(WaitingRoomPage.this, MakingRidePage.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }.start();



    }

    public void goingBack_MainPage()
    {

    }

    public void cancelMyRouteButtonClicked(View view)
    {
        
    }
    public void chatButtonClicked(View view)
    {

    }

    public void mainPageButtonClicked(View view)
    {

    }

    public void profileButtonClicked(View view)
    {

    }
}