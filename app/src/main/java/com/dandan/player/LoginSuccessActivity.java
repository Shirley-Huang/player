package com.dandan.player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginSuccessActivity extends AppCompatActivity {

    private Button showWeb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        TextView displayInfo = findViewById(R.id.displayInfo);

        //获取启动该活动的intent
        Intent intent = getIntent();
        //获取传来的数据
        String mobile = intent.getStringExtra("userMobile");
        String userName = intent.getStringExtra("userName");

        displayInfo.setText("恭喜" + mobile + "，成功登录！\n" + "hello" + userName);

        ImageView backIV = findViewById(R.id.successBack);
        backIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button getUserInfoButton = findViewById(R.id.getUserInfoButton);
        getUserInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(LoginSuccessActivity.this, UserInfoActivity.class);
                startActivity(intent);

            }
        });


        showWeb = findViewById(R.id.showWeb);
        showWeb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //接收uri对象，主要用于指定当前Intent正在操作的数据
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });



    }

    /**
     * 活动中使用Menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * 重写定义菜单的响应事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.i("LoginSuccessActivity", item.toString());

        switch (item.getItemId()){
            case R.id.parts_item :
                Toast.makeText(LoginSuccessActivity.this, "查看备件列表", Toast.LENGTH_SHORT).show();
                break;
            case R.id.wallet_item :
                Toast.makeText(LoginSuccessActivity.this, "钱包列表", Toast.LENGTH_SHORT).show();
                break;

        }


        return true;
    }
}
