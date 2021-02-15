package com.example.ourbucketlist;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    ArrayList<ModelClass> userList;
    Context context;
    private OnNoteListener mOnNoteListener;


    public Adapter (ArrayList<ModelClass> userList, Context context, OnNoteListener onNoteListener){
        this.userList=userList;
        this.context=context;
        this.mOnNoteListener = onNoteListener;





    }




    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view, mOnNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        final ModelClass temp = userList.get(position);

        String title = userList.get(position).getTitleTextView();
        String description = userList.get(position).getDescriptionTextView();
        String latitude = userList.get(position).getLatitudeTextView();
        String longitude = userList.get(position).getLongitudeTextView();
        String date = userList.get(position).getDateTextView();
        boolean isChecked = userList.get(position).isChecked();


        holder.isChecked.setTag(userList.get(position));






        holder.isChecked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                //notifyItemMoved(position,userList.size()-1);

                //notifyItemMoved(position,userList.size()-1);








            }
        });



        holder.setData(isChecked,title, description, latitude, longitude, date);


       /*
        holder.titleText.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               Intent intent = new Intent(context, editItem.class);
               intent.putExtra("editTitle", temp.getTitleTextView());
               intent.putExtra("editDescription", temp.getDescriptionTextView());
               intent.putExtra("editLatitude", temp.getLatitudeTextView());
               intent.putExtra("editLongitude", temp.getLongitudeTextView());
               intent.putExtra("editDate", temp.getDateTextView());
               intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               context.startActivity(intent);

           }
        });

        */



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView titleText;
        private TextView descriptionText;
        private TextView latitudeText;
        private TextView longitudeText;
        private TextView dateText;
        private CheckBox isChecked;
        OnNoteListener onNoteListener;


        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            titleText = itemView.findViewById(R.id.title);
            descriptionText = itemView.findViewById(R.id.description);
            latitudeText = itemView.findViewById(R.id.latitude);
            longitudeText = itemView.findViewById(R.id.longitude);
            dateText = itemView.findViewById(R.id.date);
            isChecked = itemView.findViewById(R.id.checkBox);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);




        }

        public void setData(boolean isChecked, String title, String description, String latitude, String longitude, String date) {

            titleText.setText(title);
            descriptionText.setText(description);
            latitudeText.setText(latitude);
            longitudeText.setText(longitude);
            dateText.setText(date);
            isChecked = true;
        }


        @Override
        public void onClick(View view) {

            onNoteListener.onNoteClick(getAdapterPosition());

        }
    }

    public interface OnNoteListener{
        void onNoteClick (int position);

    }
}
