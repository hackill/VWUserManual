package com.vm.user.manual.android.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vm.user.manual.android.MainActivity;
import com.vm.user.manual.android.R;
import com.vm.user.manual.android.UserManualActivity;
import com.vm.user.manual.android.event.MessageHub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * fragment 必须要依赖activity
 */
public class Page1Fragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用于传输数据
//        getActivity().getIntent().getStringExtra("dddd")
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //通过布局创建fragment的页面
        View view = View.inflate(inflater.getContext(), R.layout.fragment_page1, null);
        initView(view);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initView(View view) {
        //在fragment里面 必须要对某个view进行findviewbyId

        //通过view 去find一个组件，这个组件设置一个监听
        view.findViewById(R.id.btn_skip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });

        //通过view 去find一个组件，这个组件设置一个监听
        view.findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageHub.getInstance().sendMessage("Start");
            }
        });

    }


}
