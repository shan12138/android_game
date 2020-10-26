package com.css.smallgame10;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Integer score = 0;
    Long time = 1000L * 10;
    boolean flag = true;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = findViewById(R.id.button);
        final TextView tv1 = findViewById(R.id.score);
        final TextView tv2 = findViewById(R.id.time);
        Log.e("MyLog", "-----------------------Activity creates");
        if(savedInstanceState != null) {
            score = Integer.parseInt(savedInstanceState.getString("score"));
            time = Long.parseLong(savedInstanceState.getString("time"));
        }
        tv1.setText(getString(R.string.score,score.toString()));
        tv2.setText(getString(R.string.time,String.valueOf(time/1000)));
        countDownTimer = new CountDownTimer(time, 1000L) {
            @Override
            public void onTick(long millisUntilFinished) {
                time = millisUntilFinished;
                Log.e("MyLog", "-----------------------"+millisUntilFinished);
                tv2.setText(getString(R.string.time,String.valueOf(millisUntilFinished/1000)));
            }
            @Override
            public void onFinish() {
                btn.setVisibility(View.INVISIBLE);
            }
        };
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag) {
                    countDownTimer.start();
                    flag = false;
                }
                score++;
                tv1.setText(getString(R.string.score,score.toString()));
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("score",score+"");
        outState.putString("time",time+"");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyLog", "-----------------------Activity starts");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyLog", "-----------------------Activity resumes");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyLog", "-----------------------Activity pauses");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyLog", "-----------------------Activity stops");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyLog", "-----------------------Activity destroy");
    }

}
