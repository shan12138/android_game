package com.css.gameattack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.css.gameattack.adapter.OnItemListener;
import com.css.gameattack.adapter.WeaponAdapter;
import com.css.gameattack.entity.Weapon;
import com.css.gameattack.entity.WeaponList;

public class WeaponActivity extends AppCompatActivity {
    private WeaponList weaponList = WeaponList.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        OnItemListener onItemListener = new OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                Weapon weapon = weaponList.getWeapons().get(position);
                Intent intent = getIntent();
                //把攻击力和类别传回去
                intent.putExtra("attackNum", String.valueOf(weapon.getAttackNum()));
                intent.putExtra("weaponKind", weapon.getClass().toString());
                setResult(20, intent);
                finish();
            }
        };
        WeaponAdapter adapter = new WeaponAdapter(getApplicationContext(), R.layout.role_item,
                weaponList.getWeapons(), onItemListener);
        RecyclerView listView = findViewById(R.id.weaponList);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
    }
}
