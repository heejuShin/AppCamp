package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Lab2 extends AppCompatActivity {

    TextView t1;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);

    }
    public void onClickToast(View view) {
        Toast.makeText(getApplicationContext(),"HelloToast!", Toast.LENGTH_SHORT).show();
    }
    public void onClickCount(View view) {
        t1 = findViewById(R.id.mycount);

        count= Integer.parseInt(t1.getText().toString());
        count++;
        t1.setText(count+"");
    }

    public void onClickReset(View view) {
        count=0;
        t1.setText(count+"");
    }
}

