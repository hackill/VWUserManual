package com.vm.user.manual.android;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author hackill
 * @date 2023/10/20
 */
public class Page2Activity extends AppCompatActivity {

    ImageView mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String carId = getIntent().getStringExtra("car_id");



        setContentView(R.layout.activity_page2);

        mView = findViewById(R.id.imageview_back);

        back();
    }

    private void back() {

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Page2Activity.this.finish();
            }
        });

    }


}
