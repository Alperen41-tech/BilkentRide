package com.alperen.bilkentride.Classes;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Utilities {







    public static void showToast(Context context, String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }



    public static void animate_car(AppCompatActivity class_name, ImageView groundID){

        Handler handler = new Handler(Looper.getMainLooper());
        ArrayList<Integer> pic_names = new ArrayList<>();

        String name;

        for (int i = 1; i <= 4; i++){
            name = "animation_pic_"+i;
            int resourceId = class_name.getResources().getIdentifier(name, "drawable", class_name.getPackageName());
            pic_names.add(resourceId);
        }

        Runnable runnable = new Runnable() {

            int counter = 0;

            @Override
            public void run() {



                groundID.setImageResource(pic_names.get(counter));
                counter = (counter + 1) % pic_names.size();



                handler.postDelayed(this, 150);
            }
        };

        handler.post(runnable);

    }












}
