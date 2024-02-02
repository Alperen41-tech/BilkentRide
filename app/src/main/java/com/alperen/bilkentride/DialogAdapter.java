package com.alperen.bilkentride;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alperen.bilkentride.Classes.Message;
import com.alperen.bilkentride.databinding.MessageRowBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.DialogHolder> {
    ArrayList<Message> messages;
    public DialogAdapter(ArrayList<Message> messages)
    {
        this.messages = messages;
    }
    @NonNull
    @Override
    public DialogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MessageRowBinding messageRowBinding = MessageRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DialogHolder(messageRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DialogHolder holder, int position) {
        if (messages.get(position).isMine() == true)
        {
            holder.binding.rightChatLayout.setVisibility(View.GONE);
            holder.binding.leftChatLayout.setVisibility(View.VISIBLE);

            holder.binding.myMessageText.setText(messages.get(position).getText());
            holder.binding.myNameText.setText(messages.get(position).getSentByName());

            String photoURL = messages.get(position).getSentByPhotoUrl();
            Picasso.get().load(photoURL).into(holder.binding.myProfilePhoto);
        }
        else
        {
            holder.binding.rightChatLayout.setVisibility(View.VISIBLE);
            holder.binding.leftChatLayout.setVisibility(View.GONE);

            holder.binding.yourMessageText.setText(messages.get(position).getText());
            holder.binding.yourNameText.setText(messages.get(position).getSentByName());

            String photoURL = messages.get(position).getSentByPhotoUrl();
            Picasso.get().load(photoURL).into(holder.binding.yourProfilePhoto);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class DialogHolder extends RecyclerView.ViewHolder{
        private MessageRowBinding binding;
        public DialogHolder(MessageRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
