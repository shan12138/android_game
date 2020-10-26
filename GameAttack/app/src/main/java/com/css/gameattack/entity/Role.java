package com.css.gameattack.entity;

import lombok.Data;

/**
 * 角色基类
 * @author chenshanshan
 * @time 2019/6/28 9:46
 */
@Data
public class Role {
    String name;
    int jobIcon;
    int attackNum = 0;

    public Role() {
    }

    public Role(String name, int jobIcon, int attackNum) {
        this.name = name;
        this.jobIcon = jobIcon;
        this.attackNum = attackNum;
    }
}
