package com.css.customizeadapter.entity;

import lombok.Data;

@Data
public class Dog {
    private int imageResId;
    private String name;
    private String desc;

    public Dog(int imageResId, String name, String desc) {
        this.imageResId = imageResId;
        this.name = name;
        this.desc = desc;
    }
}
