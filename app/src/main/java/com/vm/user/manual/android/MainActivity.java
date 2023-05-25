package com.vm.user.manual.android;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.vm.user.manual.android.fragment.CarListFragment;
import com.vm.user.manual.android.fragment.IDXListFragment;
import com.vm.user.manual.android.fragment.MPVListFragment;
import com.vm.user.manual.android.fragment.NEListFragment;
import com.vm.user.manual.android.fragment.SUVListFragment;
import com.vm.user.manual.android.guide.CarGuideActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {


    private TabLayout mTl;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTl = findViewById(R.id.tab_layout);
        mVp = findViewById(R.id.view_pager);

        String[] titles = {"ID.纯电", "轿车", "SUV", "MPV", "新能源"};

        MyFragmentViewPager myFragmentViewPager = new MyFragmentViewPager(getSupportFragmentManager(), titles);
        mVp.setAdapter(myFragmentViewPager);


        //表示将TabLayout 和Viewpager 进行关联
        mTl.setupWithViewPager(mVp);

    }



    public class MyFragmentViewPager extends FragmentPagerAdapter {


        private String[] mTitles;

        public MyFragmentViewPager(FragmentManager fm, String[] titles) {
            super(fm);
            mTitles = titles;
        }


        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new IDXListFragment();
                case 1:
                    return new CarListFragment();
                case 2:
                    return new SUVListFragment();
                case 3:
                    return new MPVListFragment();
                case 4:
                    return new NEListFragment();
            }
            return new IDXListFragment();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }
    }
}