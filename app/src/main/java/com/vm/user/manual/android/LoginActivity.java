package com.vm.user.manual.android;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vm.user.manual.android.login.NetRequestCallback;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 登录界面
 */
public class LoginActivity extends AppCompatActivity {
    private final String TAG = "###LoginActivity";

    private Button mBtnSignIn, mBtnSignUp;
    private EditText mEtUser, mEtPwd;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 加载布局
        setContentView(R.layout.activity_login);
        // 绑定控件
        bindView();

        // 按钮
        btnClick();
    }


    private void bindView() {
        mEtUser = findViewById(R.id.et_login_user);
        mEtPwd = findViewById(R.id.et_login_pwd);
        mBtnSignIn = findViewById(R.id.btn_sign_in);
        mBtnSignUp = findViewById(R.id.btn_sign_up);
    }

    private void btnClick() {

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "暂不支持", Toast.LENGTH_SHORT).show();
            }
        });

        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String loginName = mEtUser.getText().toString();
                String pwd = mEtPwd.getText().toString();

                if (!TextUtils.isEmpty(loginName) && !TextUtils.isEmpty(pwd)) {

                    if (pwd.length() < 3) {
                        Toast.makeText(LoginActivity.this, "密码较短", Toast.LENGTH_SHORT).show();
                    } else {

                        login(loginName, pwd, new NetRequestCallback() {
                            @Override
                            public void onSuccess() {
                                //模拟登录成功
                                gotoMainActivity();
                            }

                            @Override
                            public void onFail(String errorMsg) {
                                //模拟登录失败
                                Toast.makeText(LoginActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                } else {
                    Toast.makeText(LoginActivity.this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void login(String account, String pwd, NetRequestCallback netRequestCallback) {

        if (!TextUtils.equals(account, "18868008888")) {
            netRequestCallback.onFail("账号不对");
            return;
        }

        if (!TextUtils.equals(pwd, "123456")) {
            netRequestCallback.onFail("密码不对");
            return;
        }

        netRequestCallback.onSuccess();
    }


    public void gotoMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}