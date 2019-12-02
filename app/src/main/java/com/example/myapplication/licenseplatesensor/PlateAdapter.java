package com.example.myapplication.licenseplatesensor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.ViewHolder> {

    private TextView plateNumber;
    private ArrayList<PlateNumberModel> numberPlateModel;

    public PlateAdapter(ArrayList<PlateNumberModel> numberPlateModel) {
        this.numberPlateModel = numberPlateModel;
    }

    @Override
    public PlateAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plate_row, viewGroup, false);
        plateNumber = (TextView) v.findViewById(R.id.plate_number);
        return new ViewHolder(v, plateNumber);
    }

    @Override
    public void onBindViewHolder(PlateAdapter.ViewHolder holder, int position) {

        holder.plateNumber.setText(numberPlateModel.get(position).getPlate());


    }

    @Override
    public int getItemCount() {
        return numberPlateModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView plateNumber;

        public ViewHolder(View itemView, TextView plateNumber) {
            super(itemView);
            this.plateNumber = plateNumber;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String color = numberPlateModel.get(position).getColor();
            String make = numberPlateModel.get(position).getMake();
            String model = numberPlateModel.get(position).getModel();
            String plate = numberPlateModel.get(position).getPlate();
            String URL = numberPlateModel.get(position).getURL();
            Intent intent = new Intent(v.getContext(), PermissionScreen.class);
            intent.putExtra("color",color);
            intent.putExtra("make",make);
            intent.putExtra("model",model);
            intent.putExtra("plates",plate);
            intent.putExtra("URL",URL);
            v.getContext().startActivity(intent);
        }
    }

}