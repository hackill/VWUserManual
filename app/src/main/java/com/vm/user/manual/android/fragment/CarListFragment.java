package com.vm.user.manual.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vm.user.manual.android.R;
import com.vm.user.manual.android.dapter.ItemCarAdapter;
import com.vm.user.manual.android.guide.CarGuideActivity;
import com.vm.user.manual.android.guide.Item;
import com.vm.user.manual.android.guide.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class CarListFragment extends Fragment {


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

        Item item1 = new Item(R.drawable.newcc, "帕萨特");
        Item item2 = new Item(R.drawable.newgolfrline, "凌度L");
        Item item3 = new Item(R.drawable.new_mqbbora, "朗逸");
        Item item4 = new Item(R.drawable.newccshootingbrake, "CC");
        Item item5 = new Item(R.drawable.sagitarlongnew, "辉腾");
        Item item6 = new Item(R.drawable.magotangte, "桑塔纳");
        Item item7 = new Item(R.drawable.magotanpa, "速腾");
        Item item8 = new Item(R.drawable.golf_gti, "高尔夫");
        characterList.add(item1);
        characterList.add(item2);
        characterList.add(item3);
        characterList.add(item4);
        characterList.add(item5);
        characterList.add(item6);
        characterList.add(item7);
        characterList.add(item8);

        ItemCarAdapter adapter = new ItemCarAdapter(characterList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Toast.makeText(getActivity(), "点击了" + item.textview, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), CarGuideActivity.class);
                intent.putExtra("KEY_CAR_NAME", item.textview);
                startActivity(intent);

            }
        });


    }


}
