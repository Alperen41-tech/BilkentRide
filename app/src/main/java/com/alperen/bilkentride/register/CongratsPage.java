package com.alperen.bilkentride.register;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;

import com.alperen.bilkentride.FindingRingAndRidePage;
import com.alperen.bilkentride.R;
import com.alperen.bilkentride.databinding.ActivityBirthdayGetBinding;
import com.alperen.bilkentride.databinding.ActivityCongratsPageBinding;

public class CongratsPage extends AppCompatActivity {

    private ActivityCongratsPageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCongratsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }





    public void goToMainPageButtonClicked(View view){

        binding.imageView6.setVisibility(View.INVISIBLE);
        binding.textView2.setVisibility(View.INVISIBLE);
        binding.textView4.setVisibility(View.INVISIBLE);
        binding.congratsButton.setVisibility(View.INVISIBLE);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        /*new CountDownTimer(10000, 275){

            double rocket_y = binding.rocket.getY();
            int counter = 0;
            double x = 0;
            @Override
            public void onTick(long millisUntilFinished) {

                binding.rocket.setY((float) rocket_y);
                rocket_y -= 5;

                binding.congratsGround.setX((float) x);

                x += Math.pow(-1, counter)*5 ;
                counter++;

                if (rocket_y >= screenHeight/2) {
                    Intent intent = new Intent(CongratsPage.this, FindingRingAndRidePage.class);
                    startActivity(intent);
                    finish();
                    this.cancel();
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();*/

        // Start the animation
        ValueAnimator rocketAnimator = ValueAnimator.ofFloat(binding.rocket.getY(), screenHeight / 2);
        rocketAnimator.setDuration(2000); // Adjust as needed
        rocketAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            binding.rocket.setY(value);

            // Update other views accordingly
            // For example:
            // binding.congratsGround.setX(...);
        });

        rocketAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {}

            @Override
            public void onAnimationEnd(Animator animation) {
                // Animation ended, start the next activity
                Intent intent = new Intent(CongratsPage.this, FindingRingAndRidePage.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {}

            @Override
            public void onAnimationRepeat(Animator animation) {}
        });

        rocketAnimator.start();
    }




}