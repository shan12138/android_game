package com.css.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.dice.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dice)
        val random = Random(1)
        btn.setOnClickListener{
            val number = random.nextInt(6) + 1
            tv.text = number.toString()
            when(number) {
                1 -> image.setImageResource(R.drawable.dice_1)
                2 -> image.setImageResource(R.drawable.dice_2)
                3 -> image.setImageResource(R.drawable.dice_3)
                4 -> image.setImageResource(R.drawable.dice_4)
                5 -> image.setImageResource(R.drawable.dice_5)
                6 -> image.setImageResource(R.drawable.dice_6)
            }
        }
    }
}
