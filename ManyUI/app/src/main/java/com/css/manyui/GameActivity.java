package com.css.manyui;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.css.manyui.service.GameService;

public class GameActivity extends AppCompatActivity {
    GameService gameService = new GameService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        final Button button = findViewById(R.id.button);
        final EditText editText = findViewById(R.id.editText);
        final TextView textTv = findViewById(R.id.textView4);
        final TextView tipTv = findViewById(R.id.tipTv);
        //先拿到系统传递过来的intent对象
        Intent intent = getIntent();
        final int correctNumber = intent.getIntExtra("number", -1);
        String pattern = intent.getStringExtra("pattern");
        //取出数值
        if(pattern.equals("easy")) {
            textTv.setText(R.string.easy_text);
        }
        else{
            textTv.setText(R.string.difficult_text);
        }
        final TextView timeTv = findViewById(R.id.timeTv);
        CountDownTimer countDownTimer = new CountDownTimer(1000L * 30, 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeTv.setText(String.valueOf(millisUntilFinished/1000));
            }
            @Override
            public void onFinish() {
                //先拿到系统传递过来的intent对象
                Intent intent = getIntent();
                String number = editText.getText().toString();
                String flag;
                if(!number.equals("") && number == null) {
                    int num = Integer.parseInt(number);
                    flag= gameService.isCorrectNumber(correctNumber, num);
                    intent.putExtra("flag", flag);
                    setResult(20, intent);
                    finish();
                }
                else {
                    intent.putExtra("flag", "猜大了");
                    setResult(20, intent);
                    finish();
                }
            }
        };
        countDownTimer.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //先拿到系统传递过来的intent对象
                Intent intent = getIntent();
                int number = Integer.parseInt(editText.getText().toString());
                String flag = gameService.isCorrectNumber(correctNumber, number);
                if(flag.equals("true")) {
                    intent.putExtra("flag", "true");
                    setResult(20, intent);
                    finish();
                }
                else {
                    tipTv.setText(flag);
                }
            }
        });
    }
}
