package com.css.notelist.service;

import java.util.ArrayList;
import java.util.List;

public class NoteService {
    private List<String> noteList = new ArrayList<>();
    private static NoteService noteService = new NoteService();
    private NoteService(){}
    public static NoteService getInstance() {
        return noteService;
    }
    public List<String> getNoteList() {
        return noteList;
    }
}
