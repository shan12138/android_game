package com.css.coffeeorder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.css.coffeeorder.entity.Order;
import com.css.coffeeorder.service.OrderService;

public class MainActivity extends AppCompatActivity {
    Order order = new Order();
    OrderService orderService = new OrderService();
    ConstraintSet mainSet = new ConstraintSet();
    ConstraintSet orderSet = new ConstraintSet();
    boolean flag = false;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ConstraintLayout con1 = findViewById(R.id.home1);
        mainSet.clone(con1);
        orderSet.clone(getApplicationContext(), R.layout.order);
        final Button deleteBtn = findViewById(R.id.delete);
        final TextView coffeeNum = findViewById(R.id.coffeeNum);
        final TextView priceTv = findViewById(R.id.priceTv);
        priceTv.setText(getString(R.string.price, String.valueOf(order.getCoffeePrice()),
                String.valueOf(order.getDesertPrice())));
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(order.getCoffeeNum() == 1) {
                    deleteBtn.setVisibility(View.INVISIBLE);
                }
                deleteBtn.setVisibility(View.VISIBLE);
                order = orderService.deleteCoffeeNum(order);
                coffeeNum.setText(String.valueOf(order.getCoffeeNum()));
            }
        });
        final Button addBtn = findViewById(R.id.add);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(order.getCoffeeNum() == 10) {
                    addBtn.setVisibility(View.INVISIBLE);
                }
                addBtn.setVisibility(View.VISIBLE);
                order = orderService.addCoffeeNum(order);
                coffeeNum.setText(String.valueOf(order.getCoffeeNum()));
            }
        });
        CheckBox chocolateBox = findViewById(R.id.chocolate);
        chocolateBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    order = orderService.choiceDesert(order, "巧克力", true);
                }else{
                    order = orderService.choiceDesert(order, "巧克力", false);
                }
            }
        });
        CheckBox iceCreamBox = findViewById(R.id.iceCream);
        iceCreamBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    order = orderService.choiceDesert(order, "冰激凌", true);
                }else{
                    order = orderService.choiceDesert(order, "冰激凌", false);
                }
            }
        });
        CheckBox cookieBox = findViewById(R.id.cookie);
        cookieBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    order = orderService.choiceDesert(order, "曲奇饼", true);
                }else{
                    order = orderService.choiceDesert(order, "曲奇饼", false);
                }
            }
        });
        Button orderBtn = findViewById(R.id.orderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String result = orderService.createOrder(order);
                TextView orderTv = findViewById(R.id.order);
                orderTv.setText(result);
                TransitionManager.beginDelayedTransition(con1);
                if(flag) {
                    mainSet.applyTo(con1);
                }
                else{
                    orderSet.applyTo(con1);
                }
                flag = !flag;
            }
        });
    }
}
