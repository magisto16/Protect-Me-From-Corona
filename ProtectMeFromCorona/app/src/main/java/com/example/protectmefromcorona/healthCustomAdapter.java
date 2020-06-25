package com.example.protectmefromcorona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class healthCustomAdapter extends ArrayAdapter<healthCountry> {

    private Context context;
    private List<healthCountry> countryModelsList;
    private List<healthCountry> countryModelsListFiltered;

    public healthCustomAdapter(Context context, List<healthCountry> countryModelsList)  {
        super(context, R.layout.list_custom_item, countryModelsList);

        this.context = context;
        this.countryModelsList = countryModelsList;
        this.countryModelsListFiltered = countryModelsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item, null, true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        tvCountryName.setText(countryModelsListFiltered.get(position).getCountry());
        Glide.with(context).load(countryModelsListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelsListFiltered.size();
    }

    @Nullable
    @Override
    public healthCountry getItem(int position) {
        return countryModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
            Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    filterResults.count = countryModelsList.size();
                    filterResults.values = countryModelsList;
                } else {
                    List<healthCountry> resultsCountry = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (healthCountry itemsModel:countryModelsList) {
                        if(itemsModel.getCountry().toLowerCase().contains(searchStr)) {
                            resultsCountry.add(itemsModel);
                        }
                        filterResults.count = resultsCountry.size();
                        filterResults.values = resultsCountry;
                    }
                }

                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryModelsListFiltered = (List<healthCountry>) results.values;
                health.countryModelsList = (List<healthCountry>) results.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }
}
