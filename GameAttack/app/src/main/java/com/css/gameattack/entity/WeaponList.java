package com.css.gameattack.entity;

import com.css.gameattack.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 游戏整体的武器列表类15个
 * @author chenshanshan
 * @time 2019/6/28 9:57
 */
public class WeaponList {
    private static WeaponList weaponList = new WeaponList();
    private List<Weapon> weapons = new ArrayList<>();
    private WeaponList(){
        weapons.add(new BroadsWord("大刀", R.drawable.weapon_01, 10, "巨大无比，" +
                "可直接将敌人砍死"));
        weapons.add(new BroadsWord("快刀", R.drawable.weapon_02, 10, "巨快无比，" +
                "可迅速将敌人刺死"));
        weapons.add(new BroadsWord("宝刀", R.drawable.weapon_03, 10, "千载难逢，" +
                "价值连城"));
        weapons.add(new BroadsWord("小刀", R.drawable.weapon_04, 10, "虽小但" +
                "可造成巨大的攻击力"));
        weapons.add(new BroadsWord("金刀", R.drawable.weapon_05, 10, "表面镀金，" +
                "触摸伤身"));
        weapons.add(new Stave("普通法杖", R.drawable.weapon_06, 10, "" +
                "能储蓄的要素最少，能装载法杖核心，能放进奥术工作台"));
        weapons.add(new Stave("核心法杖", R.drawable.weapon_07, 10, "" +
                "能储备的要素较多，能装载法杖核心，不能放进奥术工作台"));
        weapons.add(new Stave("工艺权杖", R.drawable.weapon_08, 10, "" +
                "能储备的要素最多，不能装载法杖核心，能放进奥术工作台"));
        weapons.add(new Stave("魔法杖", R.drawable.weapon_09, 10, "" +
                "可产生奇异魔法"));
        weapons.add(new Stave("仙女杖", R.drawable.weapon_10, 10, "" +
                "可使持有人拥有仙女一般的魅力，迷倒万千少男"));
        weapons.add(new Sword("龙凤双剑", R.drawable.weapon_11, 10, "" +
                "两剑柄首各配一根双剑单穗。双剑同入一鞘"));
        weapons.add(new Sword("浪人剑", R.drawable.weapon_12, 10, "" +
                "古代名剑。为浪人（行踪无定者）所铸"));
        weapons.add(new Sword("青龙剑", R.drawable.weapon_13, 10, "唐代名剑"));
        weapons.add(new Sword("鸦九剑", R.drawable.weapon_14, 10, "" +
                "唐代铸剑师张鸦九所造之剑"));
        weapons.add(new Sword("火精剑", R.drawable.weapon_15, 10, "触摸可造" +
                "成火一般的剧痛"));
    }
    public static WeaponList getInstance() {
        return weaponList;
    }
    public List<Weapon> getWeapons() {
        return weapons;
    }
}
