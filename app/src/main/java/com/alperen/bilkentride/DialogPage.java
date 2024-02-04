package com.alperen.bilkentride;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.alperen.bilkentride.Classes.Chat;
import com.alperen.bilkentride.Classes.ChatUserShowCase;
import com.alperen.bilkentride.Classes.Message;
import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.UserGet;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.alperen.bilkentride.databinding.ActivityDialogPageBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.internal.Util;

public class DialogPage extends AppCompatActivity {
    private ActivityDialogPageBinding binding;
    private String other_ıd;
    private String my_ıd;

    private FirebaseAuth my_auth;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);
        binding = ActivityDialogPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        my_auth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();


        Intent intent = getIntent();
        other_ıd = intent.getStringExtra("otherId");
        my_ıd = my_auth.getUid();


        firestore.collection("Chats")
                .whereIn("firstUserId", Arrays.asList(my_ıd, other_ıd))
                .whereIn("secondUserId", Arrays.asList(my_ıd, other_ıd)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        for (DocumentSnapshot doc: queryDocumentSnapshots){

                            String doc_Id = doc.getId();
                            Chat c = doc.toObject(Chat.class);
                            for (Message m: c.getMessagesOnThisChat()){
                                if (m.getSentById().equals(other_ıd) && !m.isRead()){
                                    m.setRead(true);
                                }
                            }

                            firestore.collection("Chats").document(doc_Id).update("messagesOnThisChat", c.getMessagesOnThisChat());

                        }


                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Utilities.showToast(DialogPage.this, e.getLocalizedMessage());
                    }
                });







        Utilities.getUserWithId(other_ıd, new UserGet() {
            @Override
            public void onGet(User user) {
                binding.hostNameText.setText(user.getUserName() + " " + user.getUserSurname());
            }
        });




        startMessaging();

    }


    public void startMessaging(){

        firestore.collection("Chats").whereIn("firstUserId", Arrays.asList(my_ıd, other_ıd)).whereIn("secondUserId", Arrays.asList(my_ıd, other_ıd)).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null){
                    Utilities.showToast(DialogPage.this, error.getLocalizedMessage());
                }

                if (value != null){
                    System.out.println("updateuı diolog");
                    updateUI(value);
                }
            }
        });



    }



    public void updateUI(QuerySnapshot docs){

        System.out.println("for dış");
        for (DocumentSnapshot doc: docs){
            System.out.println("for iç");
            Chat curr_chat = doc.toObject(Chat.class);
            ArrayList<Message> messages = curr_chat.getMessagesOnThisChat();

            for (Message m: messages){
                if (my_ıd.equals(m.getSentById())){
                    m.setMine(true);
                }
            }


            settingRecyclerView(messages);
            break;
        }


    }




    private void settingRecyclerView(ArrayList<Message> messages){
        System.out.println("updateuı");
        binding.recyclerViewDialogue.setLayoutManager(new LinearLayoutManager(DialogPage.this));
        DialogAdapter dialogAdapter = new DialogAdapter(messages);

        binding.recyclerViewDialogue.scrollToPosition(dialogAdapter.getItemCount() -1 );
        binding.recyclerViewDialogue.setAdapter(dialogAdapter);

        dialogAdapter.notifyDataSetChanged();

        



    }


    public void backButtonClicked(View view)
    {
        Intent intent = new Intent(DialogPage.this, ChatsPage.class);
        startActivity(intent);
        finish();

    }

    public void sendMessageButtonClicked(View view)
    {
        String text = binding.messageEditText.getText().toString();
        if (!text.isEmpty()){

            Message message_new = new Message();

            Utilities.getUserWithId(my_ıd, new UserGet() {
                @Override
                public void onGet(User user) {
                    message_new.setSentById(my_ıd);
                    message_new.setSentByName(user.getUserName());
                    message_new.setSentBySurname(user.getUserSurname());
                    message_new.setSentByPhotoUrl(user.getUserPhotoUrl());
                    message_new.setText(text);

                    firestore.collection("Chats").whereIn("firstUserId", Arrays.asList(my_ıd, other_ıd)).whereIn("secondUserId", Arrays.asList(my_ıd, other_ıd))
                            .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                @Override
                                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                    for (DocumentSnapshot doc: queryDocumentSnapshots){

                                        Chat chat = doc.toObject(Chat.class);
                                        ArrayList<Message> messages_on_thischat = chat.getMessagesOnThisChat();
                                        messages_on_thischat.add(message_new);

                                        String doc_Id = doc.getId();
                                        firestore.collection("Chats").document(doc_Id).update("messagesOnThisChat", messages_on_thischat);
                                        //settingRecyclerView(messages_on_thischat);
                                        binding.messageEditText.setText("");
                                    }
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Utilities.showToast(DialogPage.this, e.getLocalizedMessage());
                                }
                            });



                }
            });


        }
    }
    public void chatButtonClicked(View view)
    {

    }

    public void mainPageButtonClicked(View view)
    {

    }

    public void profileButtonClicked(View view)
    {

        Intent intent = new Intent(this, AccountSettingsPage.class);
        startActivity(intent);
        finish();

    }


}