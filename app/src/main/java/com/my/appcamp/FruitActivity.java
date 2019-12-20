package com.my.appcamp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class FruitActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    //1. 데이터
    //2. 어댑터
    //3. recyclerview setting / layout

    ArrayList<Fruit> data = new ArrayList<>();
    FruitAdapter adapter;
    RecyclerView recyclerView;
    RadioButton r1,r2,r3;
    int ImageCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);

        initRecyclerView();

    }

    void initRecyclerView(){
        loadData();
        setListView();
    }

    private void loadData(){
        data.add(new Fruit(R.drawable.apple,"사과","사과는 맛있다."));
        data.add(new Fruit(R.drawable.banana,"바나나","바나나는 맛있다."));
        data.add(new Fruit(R.drawable.rabbit1,"토끼","토끼는 귀엽다."));
    }

    private void setListView(){
        adapter = new FruitAdapter(this, data);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public void onClick(View v) {
        View view = View.inflate(this, R.layout.custom_dialog2, null);
        //context = activity(this.)
        r1=view.findViewById(R.id.r1);
        r2=view.findViewById(R.id.r2);
        r3=view.findViewById(R.id.r3);

        r1.setOnCheckedChangeListener(this);
        r2.setOnCheckedChangeListener(this);
        r3.setOnCheckedChangeListener(this);

        final EditText etTitle = view.findViewById(R.id.etTitle);
        final EditText etContent = view.findViewById(R.id.etContent);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("과일 추가")
                .setIcon(R.drawable.ic_mouse_black_24dp)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String stTitle = etTitle.getText().toString();
                        String stContent = etContent.getText().toString();
                        Toast.makeText(FruitActivity.this, stTitle+"가 추가되었습니다", Toast.LENGTH_SHORT).show();
                        if(ImageCheck==1)
                            data.add(new Fruit(R.drawable.apple,stTitle,stContent));
                        if(ImageCheck==2)
                            data.add(new Fruit(R.drawable.banana,stTitle,stContent));
                        if(ImageCheck==3)
                            data.add(new Fruit(R.drawable.handong,stTitle,stContent));
                        recyclerView.setAdapter(adapter);
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null)
                .show();
    }

    public void delete(){
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked){
            if(buttonView == r1) {
                ImageCheck=1;
            } else if(buttonView == r2){
                ImageCheck=2;
            }else if(buttonView == r3){
                ImageCheck=3;
            }else{
                ImageCheck=4;
            }

        }
    }

    public void deleteOK(){

        Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
    }

    //추가 + data.add + adapter 알리기
}
