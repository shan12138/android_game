package com.css.notelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.css.notelist.service.NoteService;

import java.util.List;

public class NoteActivity extends AppCompatActivity {
    NoteService noteService = NoteService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        Button button = findViewById(R.id.commitBtn);
        final EditText editText = findViewById(R.id.inputNote);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> noteList = noteService.getNoteList();
                String text = editText.getText().toString();
                if (!(text.equals("") || text == null))
                    noteList.add(text);
                finish();
            }
        });
    }
}
