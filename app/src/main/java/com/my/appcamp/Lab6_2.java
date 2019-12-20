package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lab6_2 extends AppCompatActivity {

    TextView tv;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_2);

        tv = findViewById(R.id.t1);
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        tv.setText(msg);
    }


    public void back(View v){
        et=findViewById(R.id.e1);
        String msg=et.getText().toString();
        Toast.makeText(this, "메세지가 전송되었습니다", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Lab6_1.class);

        intent.putExtra("msg2", msg);
        setResult(RESULT_OK,intent);
        startActivityForResult(intent, 20); //StartActivity & StartActivityForResult
        //onActivityResult(100,RESULT_OK,msg)
    }

    public void close(View view) {
        finish();
    }
    /*
    public void back(View v){
        finishActivity();
    }*/

}
