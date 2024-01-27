package com.alperen.bilkentride.Classes;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;

import javax.crypto.interfaces.PBEKey;

public class Utilities {


    private static FirebaseFirestore firestore = FirebaseFirestore.getInstance();


    public static void updateUserWithID( AppCompatActivity cont ,String user_ıd_toUpdate, User updateWith){

        Map<String, Object> data = updateWith.dataOfUser();

        firestore.collection("Users").document(user_ıd_toUpdate).update(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                showToast(cont, "Successfully saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showToast(cont, "An error occured");
            }
        });
    }




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
