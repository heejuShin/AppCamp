package com.my.appcamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class FileActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1, b2;
    String filename;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        init();
    }

    void init(){
        b1 = findViewById(R.id.btnsave);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.btnRead);
        b2.setOnClickListener(this);
        et= findViewById(R.id.e1);
        filename = getFilesDir() + "data.txt";
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btnRead:
                readFile();
                break;
            case R.id.btnsave:
                saveFile();
                break;
        }
    }

    public void readFile(){
        try {
            String str = null;
            String content = "";
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while((str=br.readLine())!=null){
                content+=str;
            }
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            displayToast("파일없음");
        }catch(IOException e){
            e.printStackTrace();
            displayToast("파일 데이터 읽기 에러");
        }

    }
    public void saveFile(){
        BufferedWriter bw = null;
        try{
           bw = new BufferedWriter(new FileWriter(filename));
           String content=et.getText().toString();
           bw.write(content);
           bw.close();

           displayToast("저장되었습니다.");
        }catch(IOException e){
            e.printStackTrace();
            //파일 생성 실패
        }
    }

    public void displayToast(String toast){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    private ArrayList<String> list = new ArrayList<>();
    public void readRawFile(View view) {
        InputStream is = getResources().openRawResource(R.raw.data);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String str = null;
        String content = "";
        try{
            while((str = br.readLine())!=null){
                    content+=str+"\n";
                }
                br.close();
                displayToast(content);

                String data[] = content.split("|");
                for(String one: data){
                    list.add(one);
                }
        }catch(FileNotFoundException e){
            e.printStackTrace();
            displayToast("파일없음");
        }catch(IOException e){
            e.printStackTrace();
            displayToast("파일 데이터 읽기 에러");
        }
    }
}