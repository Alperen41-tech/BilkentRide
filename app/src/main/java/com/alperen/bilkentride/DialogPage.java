package com.alperen.bilkentride;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.alperen.bilkentride.Classes.ChatUserShowCase;
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

    private void settingRecyclerView(ArrayList<Message> messages){
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(DialogPage.this));
        DialogAdapter dialogAdapter = new DialogAdapter(messages);
        binding.recyclerView.setAdapter(dialogAdapter);
    }
}