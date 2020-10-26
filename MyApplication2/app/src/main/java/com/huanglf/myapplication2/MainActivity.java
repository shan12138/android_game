package com.huanglf.myapplication2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    static final String[] person = {"陈姗姗","金悦","黄鲁菲","汤瑶"};
    static final String[] personInfo = new String[4];
    static final int[] personPicture = {R.drawable.shanshan1,R.drawable.jinyue,
    R.drawable.huanglufei,R.drawable.tangyao1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day3_01);
        selfIntroduction();
    }

    public void selfIntroduction(){
        String teamIntroStr = "本团队由四名成员组成，" +
                "我们每个人扮演着不同的角色，优势互补，有人擅长领导能力，" +
                "有人擅长前端界面美感设计，有人擅长后端的" +
                "逻辑设计，我相信通过我们的共同努力，会给大家呈现一个不一样的作品，希望你们能喜欢" ;
        TextView teamIntro = findViewById(R.id.teamIntro);
        teamIntro.setText(teamIntroStr);
        personInfo[0]="我，一个大大咧咧的东北女孩，热情开朗，喜欢挑战，具有较强的责任心和学习意识，" +
                "骨子里流淌着一股不服输的东北血脉。";
        personInfo[1] = "我是一个在草原邻区长大的内蒙古姑娘，性格豪迈，擅长表达，具有较强的领导能力," +
                "掌握了许多的专业技能，喜欢探索未知领域。";
        personInfo[2]="我，表面身材娇小，却蕴含着大大的能量，我相信只要付出便会有收获，对学习" +
                "具有一定的规划，喜欢将学习到的知识进行整理分类，分享给大家共同进步。";
        personInfo[3]="我，性格温和，能言善辩，学习能力较强，目标明确，喜欢旧的东西和安静的环境，" +
                "爱好游泳。";
        Button css = findViewById(R.id.css);
        buttonTest(css,0);
        Button jy = findViewById(R.id.jy);
        buttonTest(jy,1);
        Button hlf = findViewById(R.id.hlf);
        buttonTest(hlf,2);
        Button ty = findViewById(R.id.ty);
        buttonTest(ty,3);
    }



    public void buttonTest(Button button,final int index){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog(index);
            }
        });
    }

    public void dialog(int index){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(personPicture[index]);
        builder.setTitle(person[index]);
        builder.setMessage(personInfo[index]);
        builder.setPositiveButton("关闭",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog=builder.create();
        dialog.show();
    }
}
