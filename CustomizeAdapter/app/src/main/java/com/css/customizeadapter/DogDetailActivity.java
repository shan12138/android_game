package com.css.customizeadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.css.customizeadapter.entity.Dog;
import com.css.customizeadapter.entity.News;

public class DogDetailActivity extends AppCompatActivity {
    News news = News.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_detail);
        Intent intent = getIntent();
        Dog dog = news.getDogList()[intent.getIntExtra("position", -1)];
        ImageView imageView = findViewById(R.id.dogImageDetail);
        TextView name = findViewById(R.id.dogNameDetail);
        TextView desc = findViewById(R.id.dogDescDetail);
        imageView.setImageResource(dog.getImageResId());
        name.setText(dog.getName());
        desc.setText(dog.getDesc());
    }
}
