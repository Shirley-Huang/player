package com.dandan.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);



        Button getUserInfoButton = findViewById(R.id.getUserInfoButton);
        getUserInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发起网络请求,通过手机号获取用户信息

                Intent intent = new Intent();
                intent.putExtra("return_data", "userInfos");
                setResult(RESULT_OK,intent);
                // 该活动销毁后会回调上一个活动的onActivityResult方法
                finish();

            }
        });

        ImageView infoBack = findViewById(R.id.infoBack);
        infoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
