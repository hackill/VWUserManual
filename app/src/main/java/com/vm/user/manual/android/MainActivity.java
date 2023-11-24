package com.vm.user.manual.android;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vm.user.manual.android.event.MessageHub;
import com.vm.user.manual.android.event.MessageReceiver;
import com.vm.user.manual.android.fragment.ViewPageFragment1;
import com.vm.user.manual.android.fragment.ViewPageFragment2;
import com.vm.user.manual.android.fragment.ViewPageFragment3;
import com.vm.user.manual.android.fragment.ViewPageFragment4;
import com.vm.user.manual.android.fragment.ViewPageFragment5;
import com.vm.user.manual.android.fragment.ViewPageFragment6;
import com.vm.user.manual.android.fragment.ViewPageFragment7;
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

    private static ViewPager viewPager;

    private LinearLayout mOperateLinearLayout;

    private TextView mProgressTextView;

    private ImageView mImageLeft, mImageRight;

    private static int mPosition = 0;


    /**
     * activity的入口 ，可以在这个入口里设备布局和初始化一些组件
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_main);

        //通过findviewById 去初始化每个组件，id为xml文件中定义的
        // R.color.xxx  R.layout.xxx   R.id.xxx  R.dimem.xxx
        viewPager = findViewById(R.id.view_pager2);


        //创建viewpager所用到的适配器
        MyFragmentViewPager myFragmentViewPager = new MyFragmentViewPager(getSupportFragmentManager());

        //viewpaer组件设置自己的适配器
        viewPager.setAdapter(myFragmentViewPager);

        //初始化view
        initView();
        //初始监听
        initListener();

    }


    private void initView() {

        //组件初始化,需要组件与xml中的组件一致，否则会出现类型转换错误
        mOperateLinearLayout = findViewById(R.id.ll_operate);
        mProgressTextView = findViewById(R.id.text_progress);
        mImageLeft = findViewById(R.id.btn_back);
        mImageRight = findViewById(R.id.btn_go);


        //设置这个图片显示状态为gone
        mImageRight.setVisibility(View.GONE);
        mImageLeft.setVisibility(View.GONE);
        mProgressTextView.setVisibility(View.GONE);

        mOperateLinearLayout.setVisibility(View.GONE);
        mPosition = 0;//默认是第一个页面
    }

    private void initListener() {


        MessageHub.getInstance().addMessageReceiver(new MessageReceiver() {
            @Override
            public void onMessageReceive(String content) {
                //若收到的消息是start ，就做翻页
                if (TextUtils.equals("start", content)) {
                    mPosition++;
                    viewPager.setCurrentItem(mPosition);
                } else if (TextUtils.equals("ignore", content)) {
                    finish();
                }
            }
        });


        //点击进入上一页 设置监听：当点击这个按钮的时候，就会回调
        mImageLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //当点击了，需要将页面的位置 减去-1
                int newPosition = mPosition - 1;

                //告知viewpager组件 我当前的新位置
                viewPager.setCurrentItem(newPosition);
            }
        });

        mImageRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //当点击了，需要将页面的位置 +1
                int newPosition = mPosition + 1;
                //告知viewpager组件 我当前的新位置
                viewPager.setCurrentItem(newPosition);
            }
        });

        //只要是view  都有click longclick

        //viewpage有自己的一个页面滚动监听

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //代表页面滚动的位置 ，这里用不到

            }

            @Override
            public void onPageSelected(int position) {
                //代表页面滚动结束，返回当前页面的位置
                Log.i("hackill", "onPageSelected:  postion " + position);
//                if (position == 1 || position == 2) {
//                    mLinearLayout.setVisibility(View.VISIBLE);
//                } else if (position == 0) {
//                    mLinearLayout.setVisibility(View.GONE);
//                }

                //更新当前位置
                mPosition = position;

                if (position >= 1 && position <= 6) {
                    //当时第二个页面与第七个页面之间，
                    mProgressTextView.setText(position + "  /  6");
                    mImageRight.setVisibility(View.VISIBLE);
                    mImageLeft.setVisibility(View.VISIBLE);
                    mProgressTextView.setVisibility(View.VISIBLE);
                    mOperateLinearLayout.setVisibility(View.GONE);
                } else if (position == 7) {
                    //第八个页面的ui
                    mImageRight.setVisibility(View.GONE);
                    mImageLeft.setVisibility(View.VISIBLE);
                    mProgressTextView.setVisibility(View.GONE);
                    mOperateLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    // 以上无法命中的 ，属于第一个
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
                //销毁当前页面
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.btn_ignore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //销毁当前页面
                MainActivity.this.finish();
            }
        });

        findViewById(R.id.btn_open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调准到其他的app，同时销毁自己的app
                //销毁app
                MainActivity.this.finish();
                try {
                    //获取package管理对象
                    PackageManager packageManager = MainActivity.this.getPackageManager();
                    PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
                    String versionName = packageInfo.versionName;
                    int versionCode;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
                        versionCode = (int) packageInfo.getLongVersionCode();
                    } else {
                        versionCode = packageInfo.versionCode;
                    }

                    String appPackage = "com.test.test.test1";

                    Intent launchIntent = getPackageManager().getLaunchIntentForPackage(appPackage);
                    if (launchIntent != null && versionCode >= 205) {
                        startActivity(launchIntent); // null pointer check
                    } else {
                        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + appPackage);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }

                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * 如果你写一个类，这个类又不需要被外部用，作用比较小，功能有比较简单，就可以用内部类
     */
    public static class MyFragmentViewPager extends FragmentPagerAdapter {
        //集成这个adatper 代表可以快速的构造自己的页面述求

        public MyFragmentViewPager(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int i) {
            //页面顺序 返回对应的fragment,程序里顺序 都是0,1,2

//            if (i == 0) {
//                return new ViewPageFragment1();
//            } else if (i == 1) {
//                return new ViewPageFragment2();
//            } else if (i == 2) {
//                return new ViewPageFragment3();
//            } else {
//                return new ViewPageFragment2();
//            }

            switch (i) {
                case 0://当i == 0 会走到这里
                    return new ViewPageFragment1();
                case 1:
                    return new ViewPageFragment2();
                case 2:
                    return new ViewPageFragment3();
                case 3:
                    return new ViewPageFragment4();
                case 4:
                    return new ViewPageFragment5();
                case 5:
                    return new ViewPageFragment6();
                case 6:
                    return new ViewPageFragment7();
                case 7://当i == 7 会走到这里
                    return new ViewPageFragment8();
                default:
                    //默认的，以上都没有命中
                    return new ViewPageFragment2();
            }
        }

        @Override
        public int getCount() {
            //代表需要几个页面
            return 8;
        }
    }
}
