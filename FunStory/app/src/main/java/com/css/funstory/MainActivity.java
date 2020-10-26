package com.css.funstory;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.css.funstory.bussiness.Book;
import com.css.funstory.bussiness.ColorWheel;
import com.css.funstory.entity.FunStory;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        changeUI();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeUI();
            }
        });
    }

    public void changeUI() {
        TextView tv1 = findViewById(R.id.title);
        TextView tv2 = findViewById(R.id.content);
        FunStory funStory = new Book().getFunStory();
        tv1.setText(funStory.getTitle());
        tv2.setText(funStory.getContent());
        ConstraintLayout layout = findViewById(R.id.layout);
        layout.setBackgroundColor(new ColorWheel().getColor());
    }
}
