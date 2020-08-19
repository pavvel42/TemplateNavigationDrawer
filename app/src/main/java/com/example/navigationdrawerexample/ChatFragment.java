package com.example.navigationdrawerexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    private static final String TAG = ChatFragment.class.getSimpleName();
    private ArrayList<ItemCardView> exampleList;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.fragment_chat, container, false);

        exampleList = new ArrayList<>();
        exampleList.add(new ItemCardView(R.drawable.ic_send, "Line 1", "Line 2"));
        exampleList.add(new ItemCardView(R.drawable.ic_info, "Line 3", "Line 4"));
        exampleList.add(new ItemCardView(R.drawable.ic_profile, "Line 5", "Line 6"));
        exampleList.add(new ItemCardView(R.drawable.ic_send, "Line 1", "Line 2"));
        bulidRecycleView(mainView);

        return mainView;
    }

    public void bulidRecycleView(View mainView) {
        mRecyclerView = mainView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new Adapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "Position: " + exampleList.get(position).getmText1(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void removeItem(int position) {
        exampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }
}
