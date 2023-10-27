package com.vm.user.manual.android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vm.user.manual.android.fragment.ViewPageFragment1;
import com.vm.user.manual.android.fragment.ViewPageFragment2;
import com.vm.user.manual.android.fragment.ViewPageFragment3;
import com.vm.user.manual.android.fragment.ViewPageFragment8;

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

    LinearLayout mOperateLinearLayout;

    TextView mProgressTextView;

    ImageView mImageLeft, mImageRight;

    private int mPosition = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_main);

        viewPager = findViewById(R.id.view_pager2);

        MyFragmentViewPager myFragmentViewPager = new MyFragmentViewPager(getSupportFragmentManager());

        viewPager.setAdapter(myFragmentViewPager);

        initView();
        initListener();

    }

    private void initView() {

        mOperateLinearLayout = findViewById(R.id.ll_operate);
        mProgressTextView = findViewById(R.id.text_progress);
        mImageLeft = findViewById(R.id.btn_back);
        mImageRight = findViewById(R.id.btn_go);

        mImageRight.setVisibility(View.GONE);
        mImageLeft.setVisibility(View.GONE);
        mProgressTextView.setVisibility(View.GONE);

        mOperateLinearLayout.setVisibility(View.GONE);
        mPosition = 0;
    }

    private void initListener() {
        mImageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int newPosition = mPosition - 1;

                viewPager.setCurrentItem(newPosition);
            }
        });

        mImageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newPosition = mPosition + 1;

                viewPager.setCurrentItem(newPosition);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i("hackill", "onPageSelected:  postion " + position);
//                if (position == 1 || position == 2) {
//                    mLinearLayout.setVisibility(View.VISIBLE);
//                } else if (position == 0) {
//                    mLinearLayout.setVisibility(View.GONE);
//                }

                mPosition = position;

                if (position >= 1 && position <= 6) {
                    mProgressTextView.setText(position + "  /  6");
                    mImageRight.setVisibility(View.VISIBLE);
                    mImageLeft.setVisibility(View.VISIBLE);
                    mProgressTextView.setVisibility(View.VISIBLE);
                    mOperateLinearLayout.setVisibility(View.GONE);
                } else if (position == 7) {
                    mImageRight.setVisibility(View.GONE);
                    mImageLeft.setVisibility(View.VISIBLE);
                    mProgressTextView.setVisibility(View.GONE);
                    mOperateLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    mImageRight.setVisibility(View.GONE);
                    mImageLeft.setVisibility(View.GONE);
                    mProgressTextView.setVisibility(View.GONE);
                    mOperateLinearLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        findViewById(R.id.btn_end).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.btn_ignore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
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
                case 7:
                    return new ViewPageFragment8();
                default:
                    return new ViewPageFragment2();
            }
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return "";
        }

        @Override
        public int getCount() {
            return 8;
        }
    }
}
