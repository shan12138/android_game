package com.css.manyui;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.css.manyui.service.GameService;

public class MainActivity extends AppCompatActivity {
    GameService gameService = new GameService();
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView gameImage = findViewById(R.id.gameImage);
        gameImage.setImageResource(R.drawable.game);
        Button easyBtn = findViewById(R.id.easyBtn);
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显示意图标注
                intent.setClass(getApplicationContext(), GameActivity.class);
                int number = gameService.getNumber("easy");
                //把数据存储到Intent对象中
                intent.putExtra("number", number);
                intent.putExtra("pattern", "easy");
                startActivityForResult(intent, 10);
            }
        });
        Button difficultBtn = findViewById(R.id.difficultBtn);
        difficultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用显示意图标注
                intent.setClass(getApplicationContext(), GameActivity.class);
                int number = gameService.getNumber("difficult");
                //把数据存储到Intent对象中
                intent.putExtra("number", number);
                intent.putExtra("pattern", "difficult");
                startActivityForResult(intent, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //第一个参数是启动标识，第二个是回传标识
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == 20) {
                if (data != null) {
                    final ImageView gameImage = findViewById(R.id.gameImage);
                    String flag = data.getStringExtra("flag");
                    String pattern = data.getStringExtra("pattern");
                    if(flag.equals("true")) {
                        if(pattern.equals("easy")) {
                            gameImage.setImageResource(R.drawable.win1);
                        }
                        else {
                            gameImage.setImageResource(R.drawable.win2);
                        }
                    }
                    else {
                        if(pattern.equals("easy")) {
                            gameImage.setImageResource(R.drawable.lose1);
                        }
                        else {
                            gameImage.setImageResource(R.drawable.lose2);
                        }
                    }
                }
            }
        }
    }
}
