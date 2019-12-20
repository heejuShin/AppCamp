package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Lab3 extends AppCompatActivity
                implements CompoundButton.OnCheckedChangeListener{

    RadioButton r1;
    RadioButton r2;
    android.widget.ImageView ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);

        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        ImageView = findViewById(R.id.imageView1);

        r1.setOnCheckedChangeListener(this);
        r2.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            if(buttonView == r1) {
                ImageView.setImageResource(R.drawable.apple);
            } else
                ImageView.setImageResource(R.drawable.banana);

        }
    }


}
