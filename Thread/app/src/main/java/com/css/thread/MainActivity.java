package com.css.thread;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.css.thread.entity.Api;
import com.css.thread.entity.News;
import com.css.thread.entity.Repo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        final TextView textView1 = findViewById(R.id.textView1);
        final TextView textView2 = findViewById(R.id.textView2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        //设置数据解析器
                        .addConverterFactory(GsonConverterFactory.create())
                        //设置网络请求的Url地址
                        .baseUrl("http://v.juhe.cn/weather/")
                        .build();
                // 创建网络请求接口的实例
                Api api = retrofit.create(Api.class);
                Call<Repo> repo = api.getNews("json", "ae88f583c828e721e15244b0ba33a91f");
                repo.enqueue(new Callback<Repo>() {
                    //请求成功时回调
                    @Override
                    public void onResponse(Call<Repo> call, Response<Repo> response) {
                        //请求处理,输出结果-response.body().show();
                        textView1.setText(response.body().getResult()[0].getWid());
                        textView2.setText(response.body().getResult()[0].getWeather());
                    }

                    @Override
                    public void onFailure(Call<Repo> call, Throwable t) {
                        //请求失败时候的回调
                        Log.e("MyLog",t.getMessage());
                    }
                });
            }
        });
    }

}
