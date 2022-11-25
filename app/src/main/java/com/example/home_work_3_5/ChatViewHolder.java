package com.example.home_work_3_5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;



public class ChatViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView chatImageView;
    TextView chatTitleTextView;
    TextView chatMessageTextView;

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView = itemView.findViewById(R.id.chat_item);
        chatImageView = itemView.findViewById(R.id.chat_iv);
        chatTitleTextView = itemView.findViewById(R.id.title_tv);
        chatMessageTextView = itemView.findViewById(R.id.message_tv);
    }

    public void bind (int image, String title, String message) {


        chatImageView.setImageResource(image);
        chatTitleTextView.setText(title);
        chatMessageTextView.setText(message);
    }
}
