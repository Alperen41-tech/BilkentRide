package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Chat;
import com.alperen.bilkentride.Classes.Message;
import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.Classes.ChatUserShowCase;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

import kotlin.random.URandomKt;
import okhttp3.internal.Util;

public class ChatsPage extends AppCompatActivity {


    private ActivityChatsPageBinding binding;
    private FirebaseAuth my_auth;
    private FirebaseFirestore firestore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        my_auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();












        all_chatsListener();
    }



    private void all_chatsListener(){



        firestore.collection("Chats")
                .whereArrayContains("compOfId", my_auth.getUid())
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error != null){
                            Utilities.showToast(ChatsPage.this, error.getLocalizedMessage());
                        }

                        if( value != null){
                            updateUI(value);
                        }
                    }
                });

    }



    private void updateUI(QuerySnapshot docs){


        ArrayList<ChatUserShowCase> chats = new ArrayList<>();

        for (DocumentSnapshot doc: docs){
            ChatUserShowCase chat_row = new ChatUserShowCase();

            Chat chat = doc.toObject(Chat.class);


            String my_Id = my_auth.getUid();
            String other_Id = "";

            int unreadMessages = 0;
            for (Message m: chat.getMessagesOnThisChat()){
                if (m.getSentById().equals(other_Id) && !m.isRead()){
                    unreadMessages++;
                }
            }

            final int final_count = unreadMessages;

            if (my_Id.equals(chat.getFirstUserId())){
                other_Id = chat.getSecondUserId();
            }

            else{
                other_Id = chat.getFirstUserId();
            }


            firestore.collection("Users").document(other_Id).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    User other_user = documentSnapshot.toObject(User.class);
                    chat_row.setId_of_other(other_user.getId());
                    chat_row.setName(other_user.getUserName());
                    chat_row.setSurname(other_user.getUserSurname());
                    chat_row.setPhotoURL(other_user.getUserPhotoUrl());
                    chat_row.setUnreadMessage(final_count);
                    chats.add(chat_row);
                    settingRecyclerView(chats);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(ChatsPage.this, e.getLocalizedMessage());
                }
            });

        }


    }





    private void settingRecyclerView(ArrayList<ChatUserShowCase> users){
        //Todo handling recycler view according Arraylist chatUserShowCase

        System.out.println("sistem buraya girdi");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(ChatsPage.this));
        ChatsAdapter chatsAdapter = new ChatsAdapter(users);
        binding.recyclerView.setAdapter(chatsAdapter);
        chatsAdapter.notifyDataSetChanged();


        /*
         Take a look at ChatUserShowCase class, you will find how to get user name, surname and photoURL
         in addition to that to upload photo to imageView for example yo can use the fallowing method

         Picasso.get().load(photoURl).into(imageView);


         */
    }









    public void crossButtonClicked(View view)
    {
        binding.findConversationText.setText("");
    }


    public void mainPageButtonClicked(View view)
    {
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }

    public void profileButtonClicked(View view)
    {
        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();
    }


    public void backToFindingPageClicked(View view){
        Intent intent = new Intent(this, FindingRingAndRidePage.class);
        startActivity(intent);
        finish();
    }



}