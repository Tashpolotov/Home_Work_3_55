package com.example.home_work_3_5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {

   private ArrayList<ChatModel> chats;
   private OnClickListener listener;

   public ChatAdapter(ArrayList<ChatModel> chats, OnClickListener listener){
       this.chats = chats;
       this.listener = listener;
   }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

       holder.bind(chats.get(position).image, chats.get(position).title, chats.get(position).message);
       holder.itemView.setOnClickListener(view -> {
           listener.onItemClickListener(chats.get(position));
       });

       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view)
           { listener.onItemClickListener(chats.get(position));

           }
       });

    }

    @Override
    public int getItemCount() {
        return chats.size();
    }
}
