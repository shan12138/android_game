package com.css.customizeadapter.entity;

import com.css.customizeadapter.R;


public class News {
    private Dog[] dogList = {
            new Dog(R.drawable.hashiqi, "哈士奇", "西伯利亚雪橇犬,常见别名哈士奇，昵称为二哈。\n" +
                    "西伯利亚雪橇犬是原始的古老犬种，主要生活在在西伯利亚东北部、格陵兰南部。" +
                    "哈士奇名字是源自其独特的嘶哑叫声。哈士奇、金毛犬与拉布拉多并列为三大无攻击性犬类"),
            new Dog(R.drawable.zangao, "藏獒", "又名西藏獒犬，属獒犬类，是一种体型较大性格" +
                    "凶猛的犬。其毛色多为铁包金、黄色、黑色等，原产于青藏高原。它气质刚强，尊贵而高傲，" +
                    "力量强大，动作敏捷矫健，耐力较差，幼犬在成年以前记忆力较差"),
            new Dog(R.drawable.guibinquan, "贵宾犬", "贵宾犬（Poodle），也称“贵妇犬”，" +
                    "又称“卷毛狗”，在德语中，Pudel是“水花飞溅”的意思，是犬亚科犬属的一种动物。" +
                    "贵宾犬的来源就像它为了拖出猎禽所涉过的水一样浑浊不清"),
            new Dog(R.drawable.qiutianquan, "秋田犬", "秋田犬（あきたいぬ/アキタイヌ）是" +
                    "日本国犬，在日本是家庭宠物犬。该犬十分勇猛、感觉锐敏、忠诚且聪明，有关其忠诚的故" +
                    "事很多。秋田县是秋田犬发祥地，该地区北部多山，而且冬季十分寒冷"),
            new Dog(R.drawable.samoye, "萨摩耶", "萨摩耶犬（英文：Samoyed），别称萨摩耶，原是西伯利亚的原住民萨摩耶族培育出的犬种，" +
                    "一岁前调皮、灵动。它机警、强壮、灵活、美丽、高贵优雅、乖巧可爱，" +
                    "有着非常引人注目的外表，有“微笑天使”的称号，也有着“微笑天使面孔，捣蛋魔鬼内心”之称。"),
            new Dog(R.drawable.bagequan, "八哥犬", "巴哥犬（pug），原产于中国，富有魅力而" +
                    "且高雅，14世纪末正式命名为“巴哥”其词意古语为“锤头”、“小丑”，狮子鼻或小猴" +
                    "子的意思。巴哥犬容易有睫毛倒插的毛病，头部皱折多，也容易泪管阻塞，而有两条明" +
                    "显的泪痕。巴哥犬是体贴，可爱的小型犬种，不需要运动或经常整理背毛，但需要同伴。"),
    };
    private static News dogs = new News();
    private News(){}
    public static News getInstance() {
        return dogs;
    }
    public Dog[] getDogList() {
        return dogList;
    }
}
