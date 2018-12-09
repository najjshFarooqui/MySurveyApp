package com.example.administrator.retroitfetchdata.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.history.HistoryResponse.SurveyHistory;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private List<SurveyHistory> histories;
    private Context context;

    public HistoryAdapter(Context context, List<SurveyHistory> histories) {
        this.context = context;
        this.histories = histories;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history, viewGroup, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder historyHolder, int position) {
        historyHolder.bindto(histories.get(position));
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    protected class HistoryHolder extends RecyclerView.ViewHolder {

        TextView questionLabel;
        TextView dateLabel;
        TextView countryLabel;
        TextView provinceLabel;
        Button resultButton;

        private HistoryHolder(@NonNull View view) {
            super(view);
            questionLabel = view.findViewById(R.id.questionLabel);
            dateLabel = view.findViewById(R.id.dateLabel);
            countryLabel = view.findViewById(R.id.countryLabel);
            provinceLabel = view.findViewById(R.id.provinceLabel);
            resultButton = view.findViewById(R.id.resultButton);
        }

        protected void bindto(SurveyHistory history) {
            questionLabel.setText(history.question);
            dateLabel.setText(history.surveyDate);
            countryLabel.setText(history.countryName);
            resultButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "button clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

