package com.vm.user.manual.android;

import android.os.Bundle;

import com.vm.user.manual.android.fragment.ViewPageFragment1;
import com.vm.user.manual.android.fragment.ViewPageFragment2;
import com.vm.user.manual.android.fragment.ViewPageFragment3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * @author hackill
 * @date 2023/10/20
 */
public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_main);

        viewPager = findViewById(R.id.view_pager2);

        MyFragmentViewPager myFragmentViewPager = new MyFragmentViewPager(getSupportFragmentManager());

        viewPager.setAdapter(myFragmentViewPager);
    }

    public class MyFragmentViewPager extends FragmentPagerAdapter {


        public MyFragmentViewPager(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return new ViewPageFragment1();
                case 1:
                    return new ViewPageFragment2();
                case 2:
                    return new ViewPageFragment3();
            }
            return new ViewPageFragment1();
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
