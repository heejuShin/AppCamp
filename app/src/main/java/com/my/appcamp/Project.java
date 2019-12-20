//추가로 할것
/*
1) 데이터 추가
2) 데이터 삭제
3) 카드 뷰로 변경
4) File IO
 */
package com.my.appcamp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

final public class Project extends AppCompatActivity {

    ArrayList<DOL> data = new ArrayList<>();
    DolAdapter adapter;
    RecyclerView rv;
    int[] image = {R.drawable.bae1, R.drawable.bae2, R.drawable.da1, R.drawable.ye1, R.drawable.bo1, R.drawable.gun, R.drawable.kang};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        init();
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
                //addData();
                return true;

            case R.id.action_menu:
                return true;
        }
        return true;
    }

    public void addData() {
        return;
    }

}
