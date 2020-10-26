package com.css.notelist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.css.notelist.service.NoteService;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    NoteService noteService = NoteService.getInstance();
    List<String> noteList = noteService.getNoteList();
    ArrayAdapter adapter;
    SharedPreferences sharedPreferences;
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //读取保存数据
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        setContentView(R.layout.activity_main);
        String result = sharedPreferences.getString("note", null);
        if (result != null) {
            noteList.clear();
            noteList.addAll(Arrays.asList(result.split("110")));
        }
        //第一个参数为上下文环境，第二个参数为设置列表的布局文件，第三个参数为设置列表的条目，第四个是数据源
        adapter = new ArrayAdapter(getApplicationContext(),
                R.layout.note_item,
                R.id.noteItem,
                noteList);
        ListView listView = findViewById(R.id.noteList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                TextView textView = view.findViewById(R.id.noteItem);
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("任务");
                builder.setMessage(textView.getText());
                builder.setCancelable(true);
                builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        noteList.remove(position);
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();
            }
        });
        Button button = findViewById(R.id.addNoteBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(getApplicationContext(), NoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        //先拿到编辑器
        SharedPreferences.Editor edit = sharedPreferences.edit();
        //将数据存进去commit提交
        List<String> noteList = noteService.getNoteList();
        StringBuilder result = new StringBuilder();
        for (String note : noteList) {
            result.append(note);
            result.append("110");
        }
        edit.putString("note", result.toString()).commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        adapter.notifyDataSetChanged();
    }
}
