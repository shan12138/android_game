package com.css.customizeadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.css.customizeadapter.adapter.DogAdapter;
import com.css.customizeadapter.adapter.RecycleViewItemListener;
import com.css.customizeadapter.entity.News;

public class MainActivity extends AppCompatActivity {
    News news = News.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecycleViewItemListener recycleViewItemListener = new RecycleViewItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.putExtra("position", position);
                intent.setClass(getApplicationContext(), DogDetailActivity.class);
                startActivity(intent);
            }
        };
        DogAdapter adapter = new DogAdapter(getApplicationContext(), R.layout.dog_item,
                news.getDogList(), recycleViewItemListener);
        RecyclerView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
//        listView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
