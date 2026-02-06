package com.example.lab5_starter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {
    private ArrayList<City> cities;
    private Context context;
    private OnDeleteClickListener listener;

    public interface OnDeleteClickListener {
        void onDeleteClick(City city);
    }

    public CityArrayAdapter(Context context, ArrayList<City> cities, OnDeleteClickListener listener){
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_city, parent, false);
        }

        City city = cities.get(position);
        TextView movieName = view.findViewById(R.id.textCityName);
        TextView movieYear = view.findViewById(R.id.textCityProvince);
        Button deleteCityBtn = view.findViewById(R.id.deleteCityBtn);

        deleteCityBtn.setOnClickListener(v -> {
            listener.onDeleteClick(city);
        });

        movieName.setText(city.getName());
        movieYear.setText(city.getProvince());

        return view;
    }
}
