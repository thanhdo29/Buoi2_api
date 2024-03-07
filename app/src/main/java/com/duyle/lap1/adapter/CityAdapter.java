package com.duyle.lap1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.duyle.lap1.R;
import com.duyle.lap1.model.City;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder>{
    private List<City>cityList;
    private Context context;

    public CityAdapter(List<City> cityList, Context context) {
        this.cityList = cityList;
        this.context = context;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);
        return new CityViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        City city = cityList.get(position);
        holder.bind(city);
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    class CityViewHolder extends RecyclerView.ViewHolder{
        private TextView cityNameTextView, stateCountryTextView, populationTextView;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            cityNameTextView = itemView.findViewById(R.id.cityNameTextView);
            stateCountryTextView = itemView.findViewById(R.id.textViewStateCountry);
            populationTextView = itemView.findViewById(R.id.textViewPopulation);
        }

        public void bind(City city) {
            cityNameTextView.setText(city.getName());
            stateCountryTextView.setText(city.getState() + ", " + city.getCountry());
            populationTextView.setText("Population: " + String.valueOf(city.getPopulation()));
        }
    }
}
