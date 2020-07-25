package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class myadapter extends RecyclerView.Adapter {

    String mails[];
    Context ctx;
    TextView tv;
    myadapter(Context ctx, String[] values){
        this.ctx = ctx;
        this.mails = values;
    }
    @NonNull
    @Override
    public myadapter.DataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View myview = inflater.inflate(R.layout.datalayout,viewGroup,false);
        return new myadapter.DataHolder(myview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        DataHolder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class DataHolder extends RecyclerView.ViewHolder{

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.data1);
        }
    }
}

