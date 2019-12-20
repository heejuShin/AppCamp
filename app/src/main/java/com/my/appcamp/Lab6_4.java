package com.my.appcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Lab6_4 extends AppCompatActivity {

    MultiAutoCompleteTextView title;
    MultiAutoCompleteTextView content;
    String[] results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_4);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        results = msg.split("\n\n");

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        //Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_SHORT).show();

         try{
             content.setText(results[2]);
             title.setText(results[1]);
        }catch(RuntimeException e) {
             content.setText(results[1]);
         }
    }



    public void store(View view) {
        String newTitle = title.getText().toString();
        String newContent = content.getText().toString();
        String result;

        if(newTitle.equals(""))
            result = results[0] + "!@#@!" + newContent;
        else
            result = results[0] + "!@#@!" + newTitle + "\n\n" + newContent;

        Intent intent = new Intent(getApplicationContext(), Lab6_3.class);
        intent.putExtra("msg", result);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        startActivity(intent);

    }
    public void back(View view) {
        finish();
    }
}
