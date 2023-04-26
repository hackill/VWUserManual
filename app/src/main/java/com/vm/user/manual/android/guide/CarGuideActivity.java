package com.vm.user.manual.android.guide;

import android.os.Bundle;
import android.widget.Toast;

import com.vm.user.manual.android.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarGuideActivity extends AppCompatActivity {

    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_guide);


        RecyclerView recyclerView = findViewById(R.id.receiver_view);


        List<Item> characterList = new ArrayList<>();

        Item item1 = new Item(R.drawable.img_1, "途观L 你好");
        Item item2 = new Item(R.drawable.img_1, "途观L 你好2");
        Item item3 = new Item(R.drawable.img_1, "途观L 你好3");
        Item item4 = new Item(R.drawable.img_1, "途观L 你好4");
        Item item5 = new Item(R.drawable.img_1, "途观L 你好5");
        Item item6 = new Item(R.drawable.img_1, "途观L 你好6");
        characterList.add(item1);
        characterList.add(item2);
        characterList.add(item3);
        characterList.add(item4);
        characterList.add(item5);
        characterList.add(item6);

        adapter = new ItemAdapter(characterList);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


        adapter.setListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Toast.makeText(CarGuideActivity.this, "点击了" + item.textview, Toast.LENGTH_SHORT).show();
            }
        });

    }
}