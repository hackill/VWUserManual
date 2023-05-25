package com.vm.user.manual.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vm.user.manual.android.R;
import com.vm.user.manual.android.dapter.ItemCarAdapter;
import com.vm.user.manual.android.guide.Item;
import com.vm.user.manual.android.guide.ItemAdapter;
import com.vm.user.manual.android.guide.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class IDXListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(inflater.getContext(), R.layout.fragment_idx_list, null);
        initView(view);
        return view;
    }


    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.receiver_view);

        List<Item> characterList = new ArrayList<>();

        Item item1 = new Item(R.drawable.id6, "ID.6 X");
        Item item2 = new Item(R.drawable.id4, "ID.4 X");
        Item item3 = new Item(R.drawable.id_cx, "ID.3");
        characterList.add(item1);
        characterList.add(item2);
        characterList.add(item3);

        ItemCarAdapter adapter = new ItemCarAdapter(characterList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Toast.makeText(getActivity(), "点击了" + item.textview, Toast.LENGTH_SHORT).show();
            }
        });


    }

}
