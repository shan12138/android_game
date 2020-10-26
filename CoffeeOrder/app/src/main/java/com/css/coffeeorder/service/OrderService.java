package com.css.coffeeorder.service;

import com.css.coffeeorder.entity.Order;

public class OrderService {
    public Order addCoffeeNum(Order order) {
        int num = order.getCoffeeNum();
        if(num == 10)
            return order;
        order.setCoffeeNum(++num);
        return order;
    }
    public Order deleteCoffeeNum(Order order) {
        int num = order.getCoffeeNum();
        if (num == 1)
            return order;
        order.setCoffeeNum(--num);
        return order;
    }
    public Order choiceDesert(Order order, String desertName, boolean flag) {
        int[] desertNum = order.getDesertNum();
        int i = 0;
        for(String desert:order.getDesert()) {
            if(desert.equals(desertName)) {
                if(flag) {
                    desertNum[i]++;
                }
                else {
                    desertNum[i]--;
                }
            }
            i++;
        }
        order.setDesertNum(desertNum);
        return order;
    }
    public String createOrder(Order order) {
        int[] desertNum = order.getDesertNum();
        int desert = 0;
        String desertName = "";
        for(int i = 0; i < desertNum.length ;i++) {
            desert += desertNum[i];
            if(desertNum[i] != 0){
                desertName += order.getDesert()[i]+";";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("您订购了");
        stringBuilder.append(order.getCoffeeNum()+"杯咖啡;");
        if(desert != 0) {
            stringBuilder.append(desert);
            stringBuilder.append("份甜品："+desertName+";");
        }
        int price = order.getCoffeePrice() * order.getCoffeeNum() + order.getDesertPrice() * desert;
        stringBuilder.append("总价为" + price);
        return stringBuilder.toString();
    }
}
