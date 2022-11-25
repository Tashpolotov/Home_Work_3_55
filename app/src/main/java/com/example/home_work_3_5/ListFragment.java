package com.example.home_work_3_5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;


public class ListFragment extends Fragment implements OnClickListener {

    RecyclerView chatRecyclerView;
    ChatAdapter chatAdapter;
    private ArrayList<ChatModel> chats;
    ExtendedFloatingActionButton addButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chatRecyclerView = view.findViewById(R.id.chat_rv);
        addButton = view.findViewById(R.id.add_btn);
        chats = new ArrayList<>();
        setChats();
        chatRecyclerView.setAdapter(chatAdapter = new ChatAdapter(chats, this));


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chats.add(0, new ChatModel(R.drawable.chat1, "new chat", ""));
                chatAdapter.notifyDataSetChanged();

            }
        });
    }


    @Override
    public void onItemClickListener(ChatModel chatModel) {
        Bundle bundle = new Bundle();
        DetailsFragment detailsFragment = new DetailsFragment();
        bundle.putString("message", chatModel.message);
        bundle.putString("title", chatModel.title);
        bundle.putInt("image", chatModel.image);
        detailsFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container, detailsFragment).commit();
    }

    private void setChats() {

        chats.add(new ChatModel(R.drawable.chat1, "Geektecth50-3", "Akbar"));
        chats.add(new ChatModel(R.drawable.chat2, "GeekStedents", "dsadsadsadsa"));
        chats.add(new ChatModel(R.drawable.chat3, "DevKG", "Продам плейстейшн"));
        chats.add(new ChatModel(R.drawable.chat4, "Java", "Java 2022"));
        chats.add(new ChatModel(R.drawable.chat5, "Книги для IT", "Скачать книгу"));
        chats.add(new ChatModel(R.drawable.chat1, "Geektecth50-3", "Akbar"));
        chats.add(new ChatModel(R.drawable.chat2, "GeekStedents", "dsadsadsadsa"));
        chats.add(new ChatModel(R.drawable.chat3, "DevKG", "Продам плейстейшн"));
        chats.add(new ChatModel(R.drawable.chat4, "Java", "Java 2022"));
        chats.add(new ChatModel(R.drawable.chat5, "Книги для IT", "Скачать книгу"));


    }

}