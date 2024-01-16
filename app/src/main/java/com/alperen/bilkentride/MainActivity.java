package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static void main(String[] args) {
        System.out.println("Bismillah");
    }




    public void hebele(View view){
        System.out.println("hello world");
    }




}