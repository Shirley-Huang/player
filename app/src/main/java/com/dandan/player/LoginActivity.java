package com.dandan.player;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dandan.common.utils.StringUtils;
import com.dandan.common.utils.ToastUtils;


public class LoginActivity extends AppCompatActivity {

    private EditText mLoginMobile;
    private EditText mVerifyCode;
    private Button mSubmitButton;
    private Button mSubmitButton2;
    private Button mSubmitButton3;
    private Button mSubmitButton4;
    private TextView loginAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginMobile = findViewById(R.id.login_mobile);
        mVerifyCode = findViewById(R.id.login_verify_code);
        mSubmitButton = findViewById(R.id.login_submit);
        mSubmitButton2 = findViewById(R.id.login_submit2);
        mSubmitButton3 = findViewById(R.id.login_submit3);
        mSubmitButton4 = findViewById(R.id.login_submit4);
        loginAgreement = findViewById(R.id.login_agreement);


        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobile = mLoginMobile.getText().toString().trim();
                if(StringUtils.isEmpty(mobile)){
                    Toast.makeText(LoginActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
//                    ToastUtils.toast("请输入手机号");
                    return;
                }
//
//                String code = mVerifyCode.getText().toString().trim();
//                if(StringUtils.isEmpty(code)){
//                    ToastUtils.toast("请输入验证码");
//                    return;
//                }
//
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, LoginSuccessActivity.class);
                //将要传递的数据暂存在intent中
                intent.putExtra("userMobile", mobile);
                intent.putExtra("userName", "黄丹丹");

                //判断跳转的Activity是否存在
                getPackageManager().resolveActivity(intent,0);

                startActivity(intent);
            }
        });
        mSubmitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mobile = mLoginMobile.getText().toString().trim();
//                if(StringUtils.isEmpty(mobile)){
//                    ToastUtils.toast("请输入手机号");
//                    return;
//                }
//
//                String code = mVerifyCode.getText().toString().trim();
//                if(StringUtils.isEmpty(code)){
//                    ToastUtils.toast("请输入验证码");
//                    return;
//                }
//
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, UserInfoActivity.class);
                //将要传递的数据暂存在intent中
                intent.putExtra("mobile", mobile);
                startActivityForResult(intent, 1);

            }
        });
        mSubmitButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dandan.player.ACTION_START");
                startActivity(intent);
            }
        });
        mSubmitButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("LoginActivity","点击隐式intent之自定义category");
                Intent intent = new Intent("com.dandan.player.ACTION_START");
                intent.addCategory("com.dandan.player.MY_CATEGORY");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String resultData = data.getStringExtra("return_data");
                    loginAgreement.setText(resultData);
                }
        }
    }
}
