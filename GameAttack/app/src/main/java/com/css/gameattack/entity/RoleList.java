package com.css.gameattack.entity;

import com.css.gameattack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏整体的角色列表类15个
 * @author chenshanshan
 * @time 2019/6/28 9:57
 */
public class RoleList {
    private static RoleList roleList = new RoleList();
    private List<Role> roles = new ArrayList<>();
    private RoleList(){
        roles.add(new Soldier("吕布(战士)", R.drawable.soldier, 10));
        roles.add(new Soldier("曹操(战士)", R.drawable.soldier, 10));
        roles.add(new Soldier("赵云(战士)", R.drawable.soldier, 10));
        roles.add(new Soldier("孙悟空(战士)", R.drawable.soldier, 10));
        roles.add(new Soldier("花木兰(战士)", R.drawable.soldier, 10));
        roles.add(new Master("貂蝉(法师)", R.drawable.master, 10));
        roles.add(new Master("妲己(法师)", R.drawable.master, 10));
        roles.add(new Master("芈月(法师)", R.drawable.master, 10));
        roles.add(new Master("嬴政(法师)", R.drawable.master, 10));
        roles.add(new Master("露娜(法师)", R.drawable.master, 10));
        roles.add(new Doctor("孙膑(医生)", R.drawable.doctor, 10));
        roles.add(new Doctor("太乙真人(医生)", R.drawable.doctor, 10));
        roles.add(new Doctor("蔡文姬(医生)", R.drawable.doctor, 10));
        roles.add(new Doctor("庄周(医生)", R.drawable.doctor, 10));
        roles.add(new Doctor("鬼谷子(医生)", R.drawable.doctor, 10));
    }
    public static RoleList getInstance() {
        return roleList;
    }
    public List<Role> getRoles() {
        return roles;
    }
}
