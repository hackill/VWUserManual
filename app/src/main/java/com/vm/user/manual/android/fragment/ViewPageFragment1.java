package com.vm.user.manual.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vm.user.manual.android.R;
import com.vm.user.manual.android.event.MessageHub;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author hackill
 * @date 2023/10/27
 */
public class ViewPageFragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //通过view inflate创建fragment的页面
        View view = View.inflate(inflater.getContext(), R.layout.frag_view_1, null);
        initView22(view);
        return view;
    }


    private void initView22(View view) {
        //在fragment里面 必须要对某个view进行findviewbyId

        //通过view 去find一个组件，这个组件设置一个监听

        view.findViewById(R.id.btn_start_now).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发一个消息
                MessageHub.getInstance().sendMessage("start");
            }
        });

//        view.findViewById(xx).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MessageHub.getInstance().sendMessage("ignore");
//            }
//        });

    }
}
