package com.alperen.bilkentride.Classes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;

import java.sql.SQLOutput;
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



    public static void getUserWithId(String id, UserGet getter){


        firestore.collection("Users").document(id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                getter.onGet(user);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("Failure to get user wiht ID");
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


    public static void makingNormalEdges(View component){

        GradientDrawable gradientDrawable_bold;


        gradientDrawable_bold = new GradientDrawable();
        gradientDrawable_bold.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_bold.setColor(Color.WHITE); // Set the background color (in this case, red)
        gradientDrawable_bold.setCornerRadius(40);
        gradientDrawable_bold.setStroke(0, Color.WHITE); // Set the border size (2px) and color (black)



        component.setBackground(gradientDrawable_bold);



    }


    public static void makingThickerEdges(View component, int cornerRadius, int stroke_size, int backgroudColor, int border_color){
        GradientDrawable gradientDrawable_normal;

        gradientDrawable_normal = new GradientDrawable();
        gradientDrawable_normal.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable_normal.setCornerRadius(cornerRadius);
        gradientDrawable_normal.setColor(backgroudColor); // Set the background color (in this case, red)
        gradientDrawable_normal.setStroke(stroke_size, border_color);


        component.setBackground(gradientDrawable_normal);
    }











}
