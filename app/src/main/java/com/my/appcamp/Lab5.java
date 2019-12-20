package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class Lab5 extends AppCompatActivity {

    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);
    }

    boolean isClicked=false;

    public void onClick(View v){
        if(!isClicked) {
            isClicked = true;
            onClick1(v);
        }
        else {
            isClicked= false;
            onClick2(v);
        }
    }
    public void onClick1(View v){
        Snackbar.make(v, "Snack Bar Check", Snackbar.LENGTH_LONG).show();
    }

    public void onClick2(View v){
        final Snackbar snackbar = Snackbar.make(v, "Snack Bar Check2", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("OK",new View.OnClickListener(){
            @Override
            public void onClick(View v){
                snackbar.dismiss();
            }
        }).show();
    }
}
