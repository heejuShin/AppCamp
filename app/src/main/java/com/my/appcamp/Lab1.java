package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Lab1 extends AppCompatActivity {
    Button b1;
    int coffeenum=3;
    EditText[] e = new EditText[coffeenum];
    int[] many = new int[coffeenum];
    int cost[] = {1000,1500,1700};
    int final_cost=0;
    CheckBox check;
    /*
    * 1. 아메리카노,, 개수를 알아온다.
    * 2. 할인여부
    * 3. 가격계산
    * 4. 메세지창

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        b1 = findViewById(R.id.button1);

        e[0] = findViewById(R.id.c1);
        e[1] = findViewById(R.id.c2);
        e[2] = findViewById(R.id.c3);
        check = (CheckBox)findViewById(R.id.check);
        b1.setOnClickListener(new View.OnClickListener(){ //인터페이스 구현
            @Override
            public void onClick(View v){
                //call back method (다른 것을 거쳐서 다시 내게 돌아오는 것)
                //1. edit Text 데이터 가져오기
                final_cost=0;
                for(int i=0; i<coffeenum; i++) {
                    try {
                        many[i] = Integer.parseInt(e[i].getText().toString());
                    }
                    catch(NumberFormatException nfe){
                        many[i]=0;
                    }
                    final_cost+=many[i]*cost[i];

                }
                if(check.isChecked()){
                    final_cost=(int)(final_cost*0.9);
                }
                String str = "총 금액은 "+final_cost+"원 입니다^_^";

                //2. msg 창 띄우기
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

            }
        });
    }
}
