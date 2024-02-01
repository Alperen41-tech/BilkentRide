package com.alperen.bilkentride;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alperen.bilkentride.Classes.ChatUserShowCase;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.alperen.bilkentride.databinding.ChatsPageRowBinding;

import java.util.ArrayList;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsHolder>
{
    ArrayList<ChatUserShowCase> users;

    public ChatsAdapter (ArrayList<ChatUserShowCase> users)
    {
        this.users = users;
    }
    @NonNull
    @Override
    public ChatsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        ChatsPageRowBinding chatsPageRowBinding = ChatsPageRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ChatsHolder(chatsPageRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsAdapter.ChatsHolder holder, int position)
    {
        holder.binding.nameSurnameText.setText(users.get(position).getName());
    }

    @Override
    public int getItemCount()
    {
        return users.size();
    }

    public class ChatsHolder extends RecyclerView.ViewHolder
    {
        private ChatsPageRowBinding binding;
        public ChatsHolder(ChatsPageRowBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
