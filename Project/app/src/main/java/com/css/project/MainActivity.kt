package com.css.project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import kotlinx.android.synthetic.main.home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val projectGroup = ProjectGroup("剪纸堆",R.drawable.image,
            "陈姗姗，黄鲁菲，汤瑶，金悦","""
               功能列表
                1、保存复制的文字，生成一条剪贴板记录
                2、编辑（暂时不包括新建）剪切板记录
                3、删除选中的剪切板记录，
                    （1）逐条删除
                    （2）多选删除
                    （3）清空所有
                4、合并选中的多条剪切记录
                5、给某些剪切记录加星收藏
                6、分享剪切记录
            """, "小仙女")
        tv1.text = projectGroup.projectName
        image1.setImageResource(projectGroup.projectIcon)
        tv4.text = projectGroup.projectDesc
        tv2.text = projectGroup.projectNumber
        btn.setOnClickListener{
            tv3.text = et.text
//            et.inputType = InputType.TYPE_CLASS_TEXT
        }
    }
}
