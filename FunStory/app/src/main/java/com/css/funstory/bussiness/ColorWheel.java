package com.css.funstory.bussiness;

import java.util.Random;

import lombok.Data;

@Data
public class ColorWheel {
    private String[] colorWheelList = {
            "#39add1",
            "#3079ab",
            "#c25975",
            "#e15258",
            "#f9845b",
            "#838cc7",
            "#7d669e",
            "#53bbb4",
            "#51b46d",
            "#e0ab18",
            "#637a91",
            "#f092b0",
            "#b7c0c7"
    };
    public Integer getColor() {
        String color = colorWheelList[new Random().nextInt(colorWheelList.length)];
        return android.graphics.Color.parseColor(color);
    }
}
