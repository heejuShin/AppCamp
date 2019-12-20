package com.my.appcamp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOError;

public class Lab6_1 extends AppCompatActivity {

    TextView tv;
    EditText et;
    int REQUEST_MSG=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

/*
        tv = findViewById(R.id.t1);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        tv.setText(msg);*/
        //Intent intent = getIntent();
        //String msg2 = intent.getStringExtra("msg2");
        //onActivityResult(REQUEST_MSG,RESULT_OK,getIntent());
        //tv = findViewById(R.id.t1);
        //setTvText(msg2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        et=findViewById(R.id.e1);

    }

    public void setTvText(String msg){
        tv=findViewById(R.id.t1);
        tv.setText(msg);

    }

    public void callSecondActivity(){
        Intent intent = new Intent(this, Lab6_2.class);
        startActivityForResult(intent, REQUEST_MSG);
        //startActivity(intent);
    }

    public void onClick1(View v){

        Toast.makeText(this, "페이지를 이동했습니다", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Lab6_2.class);
        startActivityForResult(intent, REQUEST_MSG);
        //startActivity(intent);
        /*
        tv=findViewById(R.id.t1);
        tv.setText("hi");*/
    }

    public void onClick2(View v){

        String msg=et.getText().toString();
        Toast.makeText(this, "메세지가 전송되었습니다", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Lab6_2.class);

        intent.putExtra("msg", msg);
        startActivityForResult(intent, REQUEST_MSG);
        //startActivity(intent);

    }

    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_MSG){
            if(resultCode==RESULT_OK){
                String msg2=data.getStringExtra("msg2");
                tv = findViewById(R.id.t1);
                tv.setText(msg2);
            }
        }
    }

}
