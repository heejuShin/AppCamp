package com.my.appcamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder>{

    Context context;
    ArrayList<Fruit> data;

    FruitAdapter(Context context, ArrayList<Fruit> data){
        this.context = context;
        this.data = data;
    }
    @NonNull
    @Override
    public FruitAdapter.FruitViewHolder
        onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View fruitview = LayoutInflater.from(context).inflate(R.layout.fruit_item, parent, false);
        FruitAdapter.FruitViewHolder viewHolder  = new FruitAdapter.FruitViewHolder(fruitview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        //view holder 개수 아는거
        return data.size();
    }

    class FruitViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvname, tvdesc;
        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.image);
            tvname = itemView.findViewById(R.id.title);
            tvdesc = itemView.findViewById(R.id.content);

            itemView.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v){

               }
            });

        }

        public void setData(Fruit one){
            iv.setImageResource(one.getImageid());
            tvname.setText(one.getName());
            tvdesc.setText(one.getDesc());
        }
    }
}

