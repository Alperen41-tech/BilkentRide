package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.alperen.bilkentride.Classes.Message;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;

import java.util.ArrayList;

public class DialogPage extends AppCompatActivity {
    private ActivityChatsPageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void backButtonClicked()
    {

    }

    public void sendMessageButtonClicked()
    {
        
    }
    public void chatButtonClicked()
    {

    }

    public void mainPageButtonClicked()
    {

    }

    public void profileButtonClicked()
    {

    }

    /*
     * This method sets recycler view to be able to show messages between users
     */
    private void settingRecyclerView(ArrayList<Message> messages){
        //Todo handling recycler view according Arraylist Message

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(DialogPage.this));
        //ChatsAdapter chatsAdapter = new ChatsAdapter();
        //binding.recyclerView.setAdapter(chatsAdapter);
        //chatsAdapter.notifyDataSetChanged();

    }
}