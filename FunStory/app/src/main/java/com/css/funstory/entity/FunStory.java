package com.css.funstory.entity;

import lombok.Data;

@Data
public class FunStory {
    private String title;
    private String content;
    public FunStory(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
