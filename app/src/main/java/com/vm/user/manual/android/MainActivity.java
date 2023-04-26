package com.vm.user.manual.android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.vm.user.manual.android.guide.CarGuideActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mButton = findViewById(R.id.button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoGuideActivity();
            }
        });


    }


    public void gotoGuideActivity() {

        Intent intent = new Intent(MainActivity.this, CarGuideActivity.class);
        startActivity(intent);
    }
}