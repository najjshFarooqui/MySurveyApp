package com.example.administrator.retroitfetchdata.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.retroitfetchdata.R;
import com.example.administrator.retroitfetchdata.network.survey.Option;

import java.util.List;

public class SurveyOptionAdapter extends RecyclerView.Adapter<SurveyOptionAdapter.OptionHolder> {

    public int selectedOption = -1;
    public int selectedPosition = -1;
    List<Option> options;

    public SurveyOptionAdapter(List<Option> options) {
        this.options = options;
    }

    @NonNull
    @Override
    public OptionHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_option, viewGroup, false);
        return new OptionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OptionHolder holder, int position) {
        holder.bindTo(options.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int prevOption = selectedPosition;
                selectedOption = options.get(holder.getAdapterPosition()).optionId;
                selectedPosition = holder.getAdapterPosition();
                notifyItemChanged(selectedPosition);
                if (prevOption != -1)
                    notifyItemChanged(prevOption);
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public class OptionHolder extends RecyclerView.ViewHolder {

        public ImageView optionImage;
        public TextView optionLabel;
        public ImageView checkImage;

        public OptionHolder(View view) {
            super(view);
            optionImage = view.findViewById(R.id.optionImage);
            optionLabel = view.findViewById(R.id.optionLabel);
            checkImage = view.findViewById(R.id.checkImage);
        }

        public void bindTo(Option option) {
            optionLabel.setText(option.optionTitle);

            if (selectedOption == option.optionId)
                checkImage.setVisibility(View.VISIBLE);
            else
                checkImage.setVisibility(View.GONE);
        }
    }
}
