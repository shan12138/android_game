package com.css.gameattack.entity;

import lombok.Data;

/**
 * 武器基类
 * @author chenshanshan
 * @time 2019/6/28 9:47
 */
@Data
public class Weapon {
    String name;
    int icon;
    int attackNum = 0;
    String desc;

    public Weapon() {
    }

    public Weapon(String name, int icon, int attackNum, String desc) {
        this.name = name;
        this.icon = icon;
        this.attackNum = attackNum;
        this.desc = desc;
    }
}
