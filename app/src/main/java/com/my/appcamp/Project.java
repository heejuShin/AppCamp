//추가로 할것
/*
1) 데이터 추가
2) 데이터 삭제
3) 카드 뷰로 변경
4) File IO

https://recipes4dev.tistory.com/168
 */
package com.my.appcamp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

final public class Project extends AppCompatActivity {

    ArrayList<DOL> data = new ArrayList<>();
    DolAdapter adapter;
    RecyclerView rv;
    int[] image = {R.drawable.bae1, R.drawable.bae2, R.drawable.da1, R.drawable.ye1, R.drawable.bo1, R.drawable.gun, R.drawable.kang, R.drawable.handong};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        init();

        adapter.setOnItemClickListener(new DolAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
                showImage(position);
            }
        }) ;
    }

    public void showImage(int position){
        View view = View.inflate(this, R.layout.custom_dialog3, null);
        //context = activity(this.)
        final TextView tv = view.findViewById(R.id.tv);
        final ImageView iv = view.findViewById(R.id.image);
        tv.setText(data.get(position).getEx());
        iv.setImageResource(data.get(position).getImageId());
        //findViewByID 현재 연결되어있는 메인xml에서 가져온다 -> view이름 앞에 객체화하기
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle(data.get(position).getName())
                .setIcon(R.drawable.ic_folder_open_black_24dp)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
                //.setPositiveButton("OK", null) //lister: 이벤트 처리
                .show();
    }

    public void init() {
        ActionBar ab = getSupportActionBar();
        ab.setTitle("MY DOL");
        loadData();
        setStyleView();

    }

    public void loadData() {
        data.add(new DOL(image[0], "배진영", "프로듀스 마지막 날"));
        data.add(new DOL(image[1], "배진영", "19.02.18 막콘"));
        data.add(new DOL(image[2], "다현", "CeCi 화보촬영 현장"));
        data.add(new DOL(image[3], "손예진", "VOGUE 화보"));
        data.add(new DOL(image[4], "박보검", "영화 시사회 찍직"));
        data.add(new DOL(image[5], "건후", "19.04.12 슈돌"));
        data.add(new DOL(image[6], "강다니엘", "앨범 자켓"));
    }

    private void setStyleView() {
        adapter = new DolAdapter(this, data);
        rv = findViewById(R.id.view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        return super.onCreateOptionsMenu(menu);
        //return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                addData();
                return true;

            case R.id.action_menu:
                return true;
        }
        return true;
    }

    public void addData() {
        View view = View.inflate(this, R.layout.custom_dialog4, null);
        //context = activity(this.)

        final EditText etTitle = view.findViewById(R.id.etTitle);
        final EditText etContent = view.findViewById(R.id.etContent);
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사진 업로드")
                .setIcon(R.drawable.ic_mouse_black_24dp)
                .setView(view)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String stTitle = etTitle.getText().toString();
                        String stContent = etContent.getText().toString();
                        Toast.makeText(Project.this, stTitle+"사진이 업로드 되었습니다", Toast.LENGTH_SHORT).show();
                        data.add(new DOL(R.drawable.handong,stTitle,stContent));
                        rv.setAdapter(adapter);
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null)
                .show();
        return;
    }

}
