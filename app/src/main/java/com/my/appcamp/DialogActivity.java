package com.my.appcamp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    //왜 버튼 글자 다 대문자로 뜨지??

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.button1)
            diaglog1();
        if (view.getId() == R.id.button2)
            diaglog2();
        if (view.getId() == R.id.button3)
            diaglog3();
        if (view.getId() == R.id.button4)
            dialog4();

    }
    private void diaglog1(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("기본 대화 상자")
            .setIcon(R.drawable.handong)
            .setMessage("삭제하시겠습니까")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    deleteOK();
                }
            }) //lister: 이벤트 처리
            .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
            //.setPositiveButton("OK", null) //lister: 이벤트 처리
            .show();
    }


    int size=5;
    String fruit[] = {"사과", "오렌지", "바나나", "키위", "블루베리"};
    int choice;
    private void diaglog2(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("라디오 대화 상자")
                .setIcon(R.drawable.handong)
                .setSingleChoiceItems(fruit, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this, fruit[i]+"", Toast.LENGTH_SHORT).show();
                        choice = i;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        chooseOK(choice);
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
                //.setPositiveButton("OK", null) //lister: 이벤트 처리
                .show();
    }

    final boolean checked[] = new boolean[size];
    private void diaglog3(){
        for(int i=0; i<size; i++)
            checked[i]=false;
        final String result="";

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("체크박스 대화 상자")
                .setIcon(R.drawable.handong)
                .setMultiChoiceItems(fruit, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        checked[i]=isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        choosesOK();
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
                //.setPositiveButton("OK", null) //lister: 이벤트 처리
                .show();
    }

    private void dialog4(){
        View view = View.inflate(this, R.layout.custom_dialog, null);
        //context = activity(this.)
        final EditText et = view.findViewById(R.id.etFruit); //view가 만들어지고 나서 선언가능
        //findViewByID 현재 연결되어있는 메인xml에서 가져온다 -> view이름 앞에 객체화하기
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("과일 추가")
                .setIcon(R.drawable.handong)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String add = et.getText().toString();
                        customOK(add);
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
                //.setPositiveButton("OK", null) //lister: 이벤트 처리
                .show();
    }


    public void deleteOK(){
        Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
    }
    public void chooseOK(int i){
        Toast.makeText(DialogActivity.this, fruit[i]+"가 선택되었습니다", Toast.LENGTH_SHORT).show();
    }
    public void choosesOK(){
        String result="";
        for(int i=0; i<size; i++){
            if(checked[i])
                result+=fruit[i]+" ";
        }
        Toast.makeText(DialogActivity.this, result+"가 선택되었습니다", Toast.LENGTH_SHORT).show();
    }
    public void customOK(String add){

        Toast.makeText(DialogActivity.this, add+"가 추가되었습니다", Toast.LENGTH_SHORT).show();
    }
}
