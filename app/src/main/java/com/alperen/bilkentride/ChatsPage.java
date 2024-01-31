package com.alperen.bilkentride;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alperen.bilkentride.Classes.Chat;
import com.alperen.bilkentride.Classes.User;
import com.alperen.bilkentride.Classes.UserGet;
import com.alperen.bilkentride.Classes.Utilities;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.alperen.bilkentride.databinding.ActivityPasswordGetBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

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
                    updateUI(value);
                }
            }
        });
    }



    private void updateUI(DocumentSnapshot doc){

        ArrayList<Chat> chats = new ArrayList<>();

        User user = doc.toObject(User.class);

        for (String otherId: user.getConversationsWithId()){
            firestore.collection("Chats")
                    .whereIn("firstUserId", Arrays.asList(user.getId(), otherId))
                    .whereIn("secondUserId", Arrays.asList(user.getId(), otherId)).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            for (DocumentSnapshot doc: queryDocumentSnapshots){
                                Chat chat = doc.toObject(Chat.class);
                                chats.add(chat);
                            }
                        }
                    });
        }










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