package com.example.ourbucketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter (List<ModelClass> userList){ this .userList=userList; }


    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {


        String title = userList.get(position).getTitleTextView();
        String description = userList.get(position).getDescriptionTextView();
        String latitude = userList.get(position).getLatitudeTextView();
        String longitude = userList.get(position).getLongitudeTextView();
        String date = userList.get(position).getDateTextView();

        holder.setData(title, description, latitude, longitude, date);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView titleText;
        private TextView descriptionText;
        private TextView latitudeText;
        private TextView longitudeText;
        private TextView dateText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.description);
            latitudeText = itemView.findViewById(R.id.latitude);
            longitudeText = itemView.findViewById(R.id.longitude);
            dateText = itemView.findViewById(R.id.date);



        }

        public void setData(String title, String description, String latitude, String longitude, String date) {

            titleText.setText(title);
            descriptionText.setText(description);
            latitudeText.setText(latitude);
            longitudeText.setText(longitude);
            dateText.setText(date);
        }
    }
}
