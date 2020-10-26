package com.css.gameattack;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.css.gameattack.adapter.RoleAdapter;
import com.css.gameattack.adapter.OnItemListener;
import com.css.gameattack.entity.Role;
import com.css.gameattack.entity.RoleList;
import com.css.gameattack.entity.Team;
import com.css.gameattack.entity.Weapon;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RoleList roleList = RoleList.getInstance();
    private int choiceNum = 0;
    private int attackSum = 0;
    //已经选择的四个角色
    private List<Team> teamList = Arrays.asList(new Team[]{new Team(), new Team(), new Team(), new Team()});
    //当前为四个角色匹配武器的序号
    private int currentNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView1 = findViewById(R.id.image1);
        final ImageView imageView2 = findViewById(R.id.image2);
        final ImageView imageView3 = findViewById(R.id.image3);
        final ImageView imageView4 = findViewById(R.id.image4);
        final TextView attackSumTv = findViewById(R.id.attackSum);
        attackSumTv.setText(getApplicationContext().getString(R.string.attackSum, attackSum));
        OnItemListener onItemListener = new OnItemListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (choiceNum <= 3) {
                    Role role = roleList.getRoles().get(position);
                    switch (choiceNum) {
                        case 0:
                            imageView1.setImageResource(role.getJobIcon());
                            break;
                        case 1:
                            imageView2.setImageResource(role.getJobIcon());
                            break;
                        case 2:
                            imageView3.setImageResource(role.getJobIcon());
                            break;
                        case 3:
                            imageView4.setImageResource(role.getJobIcon());
                            break;
                    }
                    Team team = new Team(role);
                    teamList.set(choiceNum, team);
                    //仅计算人物的攻击力
                    attackSum += role.getAttackNum();
                    attackSumTv.setText(getApplicationContext().getString(
                            R.string.attackSum, attackSum));
                    choiceNum++;
                }
            }
        };
        RoleAdapter adapter = new RoleAdapter(getApplicationContext(), R.layout.role_item,
                roleList.getRoles(), onItemListener);
        RecyclerView listView = findViewById(R.id.roleList);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(this));
        final Intent intent = new Intent();
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClick(intent, 0);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClick(intent, 1);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClick(intent, 2);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClick(intent, 3);
            }
        });
    }

    private void imageClick(Intent intent, int i) {
        if(teamList.get(i).getRole() == null) {
            Toast.makeText(MainActivity.this, "请先选择角色，才能为之分配武器", Toast.LENGTH_LONG).show();
        }
        else{
            intent.setClass(getApplicationContext(), WeaponActivity.class);
            startActivityForResult(intent, 10);
            currentNum = i;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10 && resultCode == 20) {
            if (data != null) {
                Team team = teamList.get(currentNum);
                int num = Integer.parseInt(data.getStringExtra("attackNum"));
                Weapon weapon = null;
                try {
                    weapon = (Weapon) Class.forName(data.getStringExtra("weaponKind").
                            split(" ")[1]).newInstance();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (weapon != null) {
                    weapon.setAttackNum(num);
                    team.setWeapon(weapon);
                    attackSum = calculate(teamList);
                    final TextView attackSumTv = findViewById(R.id.attackSum);
                    attackSumTv.setText(getApplicationContext().getString(R.string.attackSum, attackSum));
                }
            }
        }
    }

    private int calculate(List<Team> teamList) {
        int result = 0;
        ImageView imageView1 = findViewById(R.id.fire1);
        ImageView imageView2 = findViewById(R.id.fire2);
        ImageView imageView3 = findViewById(R.id.fire3);
        ImageView imageView4 = findViewById(R.id.fire4);
        for (int i = 0; i < teamList.size(); i++) {
            Team team = teamList.get(i);
            int attackNum = team.getAttackNum();
            result += attackNum;
            switch (i) {
                case 0:
                    if(team.isFlag()){
                        imageView1.setVisibility(View.VISIBLE);
                    }
                    else{
                        imageView1.setVisibility(View.GONE);
                    }
                    break;
                case 1:
                    if(team.isFlag()){
                        imageView2.setVisibility(View.VISIBLE);
                    }
                    else{
                        imageView2.setVisibility(View.GONE);
                    }
                    break;
                case 2:
                    if(team.isFlag()){
                        imageView3.setVisibility(View.VISIBLE);
                    }
                    else{
                        imageView3.setVisibility(View.GONE);
                    }
                    break;
                case 3:
                    if(team.isFlag()){
                        imageView4.setVisibility(View.VISIBLE);
                    }
                    else{
                        imageView4.setVisibility(View.GONE);
                    }
                    break;
            }
        }
        return result;
    }
}
