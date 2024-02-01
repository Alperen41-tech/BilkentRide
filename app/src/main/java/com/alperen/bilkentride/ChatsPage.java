package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Chat;
import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.Classes.ChatUserShowCase;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.protobuf.Value;

import java.util.ArrayList;
import java.util.Arrays;

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
        firestore.collection("Users").document(my_auth.getUid()).addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null){
                    Utilities.showToast(ChatsPage.this, error.getLocalizedMessage());
                    return;
                }

                if (value != null) {
                    updateUI(value); //user object to be returned with value
                }
            }
        });

    }



    private void updateUI(DocumentSnapshot doc){

        User current_user = doc.toObject(User.class);
        ArrayList<ChatUserShowCase> appearence_user = new ArrayList<>();


        for (String otherId: current_user.getConversationsWithId()){

            ChatUserShowCase other_user = new ChatUserShowCase();
            other_user.setId_of_other(otherId);

            firestore.collection("Users").document(otherId).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    User oth = documentSnapshot.toObject(User.class);
                    other_user.setName(oth.getUserName());
                    other_user.setSurname(oth.getUserSurname());
                    other_user.setPhotoURL(oth.getUserPhotoUrl());

                    firestore.collection("Chats")
                            .whereIn("firstUserId", Arrays.asList(current_user.getId(), oth.getId()))
                            .whereIn("secondUserId", Arrays.asList(current_user.getId(), oth.getId())).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    for (DocumentSnapshot doc: queryDocumentSnapshots){
                                        Chat curr_chat = doc.toObject(Chat.class);
                                        other_user.setUnreadMessage(curr_chat.getUnreadMessages());
                                        return;
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Utilities.showToast(ChatsPage.this, e.getLocalizedMessage());
                                }
                            });

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Utilities.showToast(ChatsPage.this, e.getLocalizedMessage());
                }
            });


            appearence_user.add(other_user);
        }


        settingRecyclerView(appearence_user);

    }



    private void settingRecyclerView(ArrayList<ChatUserShowCase> users){
        //Todo handling recycler view according Arraylist chatUserShowCase

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(ChatsPage.this));
        ChatsAdapter chatsAdapter = new ChatsAdapter(users);
        binding.recyclerView.setAdapter(chatsAdapter);

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