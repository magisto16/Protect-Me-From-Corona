package com.example.protectmefromcorona;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class whatAdapter extends RecyclerView.Adapter<whatAdapter.whatDetailVH> {

    private static final String TAG = "whatAdapter";
    List<whatDetail> descList;

    public whatAdapter(List<whatDetail> movieList) {
        this.descList = movieList;
    }

    @NonNull
    @Override
    public whatDetailVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_what_adapter, parent, false);
        return new whatDetailVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull whatDetailVH holder, int position) {

        whatDetail description = descList.get(position);
        holder.titleTextView.setText(description.getTitle());
        holder.plotTextView.setText(description.getDesc());

        boolean isExpanded = descList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return descList.size();
    }

    class whatDetailVH extends RecyclerView.ViewHolder {

        private static final String TAG = "whatDetailVH";

        ConstraintLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView, plotTextView;

        public whatDetailVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            plotTextView = itemView.findViewById(R.id.descTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);


            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    whatDetail description = descList.get(getAdapterPosition());
                    description.setExpanded(!description.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
