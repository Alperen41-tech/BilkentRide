package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Chat;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityFindingRingAndRidePageBinding;
import com.alperen.bilkentride.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindingRingAndRidePage extends AppCompatActivity {



    private ActivityFindingRingAndRidePageBinding binding;

    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFindingRingAndRidePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //getting time stampt

        /*firestore.collection("Chats").document("hebele3").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Chat chat = documentSnapshot.toObject(Chat.class);
                System.out.println(chat.getLastChangedDate());
            }
        });*/




        //creating chats

        /*firestore = FirebaseFirestore.getInstance();
        Chat random = new Chat();
        random.setFirstUserId("L6tR8YQvULOa8l4qoO5waWARJum1");
        random.setSecondUserId("YIAmVBLv3cNcuXIalwtHEAZa77x2");

        ArrayList<String> list = new ArrayList<>();
        list.add(random.getFirstUserId());
        list.add(random.getSecondUserId());

        random.setCompOfId(list);


        firestore.collection("Chats").document("hebele4").set(random).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Utilities.showToast(FindingRingAndRidePage.this , "Chat is set");
            }
        });


        Map<String, Object> hebele = new HashMap<>();
        hebele.put("lastDateChanged", FieldValue.serverTimestamp());

        firestore.collection("Chats").document("hebele4").update(hebele).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Utilities.showToast(FindingRingAndRidePage.this, "updated");
            }
        });

        /*firestore.collection("Chats").add(random).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Utilities.showToast(FindingRingAndRidePage.this, "chat is created");
            }
        });*/


    }

    public void makeRideButtonClicked(View view)
    {

    }

    public void findMeRideButtonClicked(View view)
    {

    }

    public void tellMeRingOptionButtonClicked(View view)
    {




    }

    public void chatButton1Clicked(View view)
    {
        Intent intent = new Intent(FindingRingAndRidePage.this, ChatsPage.class);
        startActivity(intent);
    }

    public void profileButton5Clicked(View view)
    {

        Intent intent = new Intent(FindingRingAndRidePage.this, AccountSettingsPage.class);
        startActivity(intent);

    }



}