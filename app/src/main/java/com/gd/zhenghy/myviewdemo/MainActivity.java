package com.gd.zhenghy.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Topbar topbar= (Topbar) findViewById(R.id.topbar);

        topbar.setonTopbarClickListener(new Topbar.TopbarClickListener() {
            @Override
            public void leftclick() {
                Toast.makeText(MainActivity.this,"left",Toast.LENGTH_LONG).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(MainActivity.this,"Right",Toast.LENGTH_LONG).show();
            }
        });
        topbar.setLeftVisible(false);
    }

}
