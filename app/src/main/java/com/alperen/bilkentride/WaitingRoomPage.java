package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

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

    private SharedPreferences time_left_sharing;

    CountDownTimer ct;


    private FirebaseFirestore firestore;
    private FirebaseAuth my_auth;
    long time_left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWaitingRoomPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();
        my_auth = FirebaseAuth.getInstance();

        time_left_sharing = this.getSharedPreferences("com.alperen.bilkentride", MODE_PRIVATE);

        time_left = time_left_sharing.getLong("timeLeft", 600000);


        ct = new CountDownTimer(time_left, 1000 ){

            @Override
            public void onTick(long millisUntilFinished) {

                int min = (int) (millisUntilFinished / 60000);
                time_left -= 1000;

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


    @Override
    protected void onPause(){
        super.onPause();
        time_left_sharing.edit().putLong("timeLeft", time_left);
    }

    public void goingBack_MainPage()
    {

    }

    public void cancelMyRouteButtonClicked(View view)
    {
        
    }
    public void waitingChatsButtonClicked(View view)
    {
        //Toast.makeText("this", "AS long as your ride is available and not selected you can't go other part, but you can safely close the application, your ride hass been already ", Toast.LENGTH_LONG);

    }

    public void mainPageButtonClicked(View view)
    {

    }

    public void profileButtonClicked(View view)
    {

    }


}