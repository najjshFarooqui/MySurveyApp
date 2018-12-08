package com.example.administrator.retroitfetchdata.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {


    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder historyHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HistoryHolder extends RecyclerView.ViewHolder {

        TextView question;
        TextView date;
        TextView Country;
        TextView provience;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            //question=itemView.findViewById(R.id.)
        }
    }
}

