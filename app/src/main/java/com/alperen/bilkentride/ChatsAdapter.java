package com.alperen.bilkentride;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alperen.bilkentride.Classes.ChatUserShowCase;
import com.alperen.bilkentride.databinding.ActivityChatsPageBinding;
import com.alperen.bilkentride.databinding.ChatsPageRowBinding;
import com.squareup.picasso.Picasso;

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
        //set name
        holder.binding.nameText.setText(users.get(position).getName());

        //set surname
        holder.binding.surnameText.setText(users.get(position).getSurname());

        //set profile photo
        String photoURL = users.get(position).getPhotoURL();
        Picasso.get().load(photoURL).into(holder.binding.profilePhotoImageC);


        /*
         * This method is related to what will happen after user click on anybody in conversation page
         */
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DialogPage.class);





                holder.itemView.getContext().startActivity(intent);
            }
        });
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