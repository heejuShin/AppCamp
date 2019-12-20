package com.my.appcamp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main4 extends AppCompatActivity {

    EditText et;
    ArrayAdapter<String> adapter;
    ArrayList<String> data = new ArrayList<String>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        init();
    }
    void init(){
        data.add(new String("apple"));
        data.add(new String("orange"));
        data.add("banana");
        data.add("kiwi");

        //ArrayAdapter(Context context, int resource, List<T> objects)
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        listView = findViewById(R.id.listview1);
        listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long l) {
                displayDeleteDialog(position);
                //displayToast(position + "");
                return false;
            }

        });


    }

    private void displayDeleteDialog(final int position){
        AlertDialog.Builder dlg = new AlertDialog.Builder(Main4.this);
        dlg.setTitle("과일삭제")
                .setIcon(R.drawable.handong)
                .setMessage("삭제하시겠습니까")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        deleteOK(position);
                    }
                })
                .setNegativeButton("CANCEL", null)
                .show();
    }

    public void deleteOK(int position){
        data.remove(position);
        adapter.notifyDataSetChanged();
        Toast.makeText(Main4.this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
    }
    public void displayToast(String data) {
        Toast.makeText(Main4.this, data, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        et = findViewById(R.id.e1);
        String add=et.getText().toString();
        data.add(new String(add));
        adapter.notifyDataSetChanged();
        Toast.makeText(Main4.this, "추가되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
