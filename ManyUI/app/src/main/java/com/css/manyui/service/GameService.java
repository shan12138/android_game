package com.css.manyui.service;

import java.util.Random;

public class GameService {
    public int getNumber(String pattern) {
        if (pattern.equals("easy")) {
            return new Random().nextInt(50);
        }
        else if (pattern.equals("difficult")) {
            return new Random().nextInt(100);
        }
        return -1;
    }

    public String isCorrectNumber(int correctNumber, int number) {
        if(correctNumber == number) {
            return "true";
        }
        else if(correctNumber > number) {
            return "猜小了";
        }
        return "猜大了";
    }
}
