package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Lab6_3 extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_3);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        try{

            String[] gets = msg.split("!@#@!");
            msg=gets[1];
            if(gets[0].equals("1")) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                try{
                    tv1=findViewById(R.id.t1);
                    tv1.setText(msg);

                }catch(RuntimeException e){
                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                }
            }
            if(gets[0].equals("2")) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                try{
                    tv2=findViewById(R.id.t2);
                    tv2.setText(msg);
                }catch(RuntimeException e){
                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                }
            }
            if(gets[0].equals("3")) {
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                try{
                    tv3=findViewById(R.id.t3);
                    tv3.setText(msg);
                }catch(RuntimeException e){
                    Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                }
            }
        }catch(RuntimeException e){

        }

     }

    public void onClick1(View v){
        Intent intent = new Intent(this, Lab6_4.class);
        tv1=findViewById(R.id.t1);
        String msg = "1\n\n"+tv1.getText().toString();

        intent.putExtra("msg", msg);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    public void onClick2(View v){
        Intent intent = new Intent(this, Lab6_4.class);
        tv2=findViewById(R.id.t2);
        String msg = "2\n\n"+tv2.getText().toString();

        intent.putExtra("msg", msg);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
    public void onClick3(View v){
        Intent intent = new Intent(this, Lab6_4.class);
        tv3=findViewById(R.id.t3);
        String msg = "3\n\n"+tv3.getText().toString();

        intent.putExtra("msg", msg);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }
}
