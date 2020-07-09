package com.example.fragmentwa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentListChat extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<ListChat> listChats;

    public FragmentListChat() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.activity_fragment_list_chat,container,false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.listchat_recyclerview);
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(getContext(),listChats);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recycleViewAdapter);

        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listChats = new ArrayList<>();
        listChats.add(new ListChat("yami","08239473202",R.drawable.yami));
        listChats.add(new ListChat("Asta","08233234234",R.drawable.asta));
        listChats.add(new ListChat("charmy","08239456476",R.drawable.charmy));
        listChats.add(new ListChat("finral","08239444322",R.drawable.finral));
        listChats.add(new ListChat("luck","08239423434",R.drawable.luck));
        listChats.add(new ListChat("magna","0823943522",R.drawable.magna));
    }
}
