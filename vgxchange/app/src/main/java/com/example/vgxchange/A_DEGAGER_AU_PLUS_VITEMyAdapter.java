package com.example.vgxchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class A_DEGAGER_AU_PLUS_VITEMyAdapter extends RecyclerView.Adapter<A_DEGAGER_AU_PLUS_VITEMyAdapter.MyViewHolder> {

    String data1[], data2[];
    Context context;

    public A_DEGAGER_AU_PLUS_VITEMyAdapter(Context ct, String s1[], String s2[]){
        context =ct;
        data1 = s1;
        data2 = s2;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.product_name_txt);
            myText2 = itemView.findViewById(R.id.product_description_txt);
        }
    }
}
