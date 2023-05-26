package com.vm.user.manual.android;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vm.user.manual.android.event.MessageHub;
import com.vm.user.manual.android.event.MessageReceiver;
import com.vm.user.manual.android.frag.Page2Fragment;
import com.vm.user.manual.android.frag.Page3Fragment;
import com.vm.user.manual.android.frag.Page4Fragment;
import com.vm.user.manual.android.frag.Page5Fragment;
import com.vm.user.manual.android.frag.Page6Fragment;
import com.vm.user.manual.android.frag.Page1Fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class UserManualActivity extends AppCompatActivity {

    private ViewPager mVp;

    private TextView mProgress;
    private ImageView backBtn;
    private ImageView goBtn;
    private LinearLayout llPage6Operate;

    private int mPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mVp = findViewById(R.id.view_pager);


        backBtn = findViewById(R.id.btn_back);
        goBtn = findViewById(R.id.btn_go);
        mProgress = findViewById(R.id.text_progress);
        llPage6Operate = findViewById(R.id.ll_operate);

        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManualActivity.this.finish();
            }
        });

        findViewById(R.id.btn_ignore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserManualActivity.this.finish();
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVp.setCurrentItem(0);
            }
        });


        UserManualActivity.MyFragmentViewPager myFragmentViewPager = new UserManualActivity.MyFragmentViewPager(getSupportFragmentManager());
        mVp.setAdapter(myFragmentViewPager);

        page1View();
        mPosition = 0;


        MessageHub.getInstance().addMessageReceiver(new MessageReceiver() {
            @Override
            public void onMessageReceive(String content) {
                if (TextUtils.equals("Start", content)) {
                    mPosition++;
                    mVp.setCurrentItem(mPosition);
                }
            }
        });


        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("hackill", "onPageSelected:  postion " + position);
                mPosition = position;

                mProgress.setText(position + "  /  4");
                if (position == 0) {
                    page1View();
                } else if (position == 5) {
                    page6tView();
                } else {
                    page2to5View();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPosition++;
                mVp.setCurrentItem(mPosition);
            }
        });


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mPosition--;
                mVp.setCurrentItem(mPosition);
            }
        });

    }

    private void page1View() {
        backBtn.setVisibility(View.INVISIBLE);
        goBtn.setVisibility(View.INVISIBLE);
        mProgress.setVisibility(View.INVISIBLE);
        llPage6Operate.setVisibility(View.INVISIBLE);
    }

    private void page2to5View() {
        backBtn.setVisibility(View.VISIBLE);
        goBtn.setVisibility(View.VISIBLE);
        mProgress.setVisibility(View.VISIBLE);
        llPage6Operate.setVisibility(View.INVISIBLE);
    }

    private void page6tView() {
        backBtn.setVisibility(View.VISIBLE);
        goBtn.setVisibility(View.INVISIBLE);
        mProgress.setVisibility(View.INVISIBLE);
        llPage6Operate.setVisibility(View.VISIBLE);
    }


    public class MyFragmentViewPager extends FragmentPagerAdapter {


        public MyFragmentViewPager(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new Page1Fragment();
                case 1:
                    return new Page2Fragment();
                case 2:
                    return new Page3Fragment();
                case 3:
                    return new Page4Fragment();
                case 4:
                    return new Page5Fragment();
                case 5:
                    return new Page6Fragment();
            }
            return new Page1Fragment();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}