package com.my.appcamp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.my.appcamp.Project;

public class DolAdapter extends RecyclerView.Adapter<DolAdapter.DolViewHolder>{

    Context context;
    ArrayList<DOL> data;


    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }

    private OnItemClickListener mListener = null ;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    DolAdapter(Context context, ArrayList<DOL> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public DolAdapter.DolViewHolder
        onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View dolview = LayoutInflater.from(context).inflate(R.layout.dol_item, parent, false);
        DolAdapter.DolViewHolder viewHolder  = new DolAdapter.DolViewHolder(dolview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DolViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        //view holder 개수 아는거
        return data.size();
    }

    class DolViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvname, tvex;
        ImageView i1,i2,i3;
        CheckedTextView ctv1, ctv2, ctv3;


        public DolViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.image);
            tvname = itemView.findViewById(R.id.name);
            tvex=itemView.findViewById(R.id.ex);
            /*
            i1=itemView.findViewById(R.id.Idown);
            i2=itemView.findViewById(R.id.Iedit);
            i3=itemView.findViewById(R.id.Ishare);
            ctv1=itemView.findViewById(R.id.down);
            ctv2=itemView.findViewById(R.id.edit);
            ctv3=itemView.findViewById(R.id.share);*/

            itemView.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                   int pos = getAdapterPosition();
                   if (pos != RecyclerView.NO_POSITION) {
                       // 리스너 객체의 메서드 호출.
                       if (mListener != null) {
                           mListener.onItemClick(v, pos);
                       }
                       custom_dialog();
                   }
               }
            });

        }

        public void setData(DOL one){

            iv.setImageResource(one.getImageId());
            tvname.setText(one.getName());
            tvex.setText(one.getEx());
            /*
            ctv1.setChecked(one.getCheck(0));
            ctv2.setChecked(one.getCheck(1));
            ctv3.setChecked(one.getCheck(2));

            i1.setImageResource(R.drawable.bae1);
            i2.setImageResource(R.drawable.bae1);
            i3.setImageResource(R.drawable.bae1);

            ctv1.setText("down");
            ctv2.setText("edit");
            ctv3.setText("share");*/

        }
    }

    private void custom_dialog(){
        System.out.println("hello");
        /*
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
                    }
                }) //lister: 이벤트 처리
                .setNegativeButton("CANCEL", null) //두 버튼의 차이 : 위치 (positive가 오른쪽 nega가 왼쪽)
                //.setPositiveButton("OK", null) //lister: 이벤트 처리
                .show();*/

        //Toast.makeText(this, "안뇽", Toast.LENGTH_SHORT).show();
    }
}

