package com.css.gameattack.entity;

import lombok.Data;

/**
 * @author chenshanshan
 * @time 2019/6/28 14:22
 */
@Data
public class Team {
    private Role role;
    private Weapon weapon;
    private int attackNum = 0;
    private boolean flag = false;

    public Team(Role role) {
        this.role = role;
        this.attackNum = role.getAttackNum();
    }

    public Team() {
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.attackNum = role.getAttackNum() + weapon.getAttackNum();
    }

    private void isCorrect() {
        //计算是否匹配的攻击值
        if (role instanceof Doctor && weapon instanceof Sword) {
            flag = true;
        } else if (role instanceof Master && weapon instanceof Stave) {
            flag = true;
        } else if (role instanceof Soldier && weapon instanceof BroadsWord) {
            flag = true;
        } else {
            flag = false;
        }
    }

    public int getAttackNum() {
        boolean temp = flag;
        isCorrect();
        if (flag && !temp)
            attackNum *= 2;
        return attackNum;
    }
}
