package com.css.coffeeorder.entity;

import lombok.Data;

@Data
public class Order {
    private int coffeeNum = 1;
    private String[] desert = {"巧克力", "冰激凌", "曲奇饼"};
    private int[] desertNum = {0, 0, 0};
    private int coffeePrice = 20;
    private int desertPrice = 10;
    private int totalPrice = 0;
}
