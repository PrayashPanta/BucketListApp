package com.example.ourbucketlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;




import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Adapter.OnNoteListener {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<ModelClass> userList;
    Adapter adapter;
    private int currentPosition;
    public static final int request_code = 01;
    public static final int edit_request_code = 02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initData();

        initRecyclerView();



        FloatingActionButton floatingbutton = (FloatingActionButton) findViewById(R.id.fab);
        floatingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,addItem.class);

                startActivityForResult(intent,request_code);

            }
        });









    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (request_code == requestCode) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String description = data.getStringExtra("description");
                String latitude = data.getStringExtra("latitude");
                String longitude = data.getStringExtra("longitude");
                String date = data.getStringExtra("date");

                userList.add(new ModelClass(false,title, description, latitude, longitude, date));

                //adapter.notifyItemInserted(userList.size()-1);


                

                Collections.sort(userList, new Comparator<ModelClass>() {


                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

                    @Override
                    public int compare(ModelClass modelClass, ModelClass t1) {
                        try {
                            return simpleDateFormat.parse(modelClass.getDateTextView()).compareTo(simpleDateFormat.parse(t1.getDateTextView()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });

                adapter.notifyDataSetChanged();


            }
        }

        if (edit_request_code == requestCode){
            if (resultCode == RESULT_OK){
                String newTitle = data.getStringExtra("newTitle");
                String newDescription = data.getStringExtra("newDescription");
                String newLatitude = data.getStringExtra("newLatitude");
                String newLongitude = data.getStringExtra("newLongitude");
                String newDate = data.getStringExtra("newDate");

                userList.set(currentPosition, new ModelClass(false,newTitle,newDescription,newLatitude,newLongitude,newDate));
                //adapter.notifyDataSetChanged();



                Collections.sort(userList, new Comparator<ModelClass>() {


                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

                    @Override
                    public int compare(ModelClass modelClass, ModelClass t1) {
                        try {
                            return simpleDateFormat.parse(modelClass.getDateTextView()).compareTo(simpleDateFormat.parse(t1.getDateTextView()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });

                adapter.notifyDataSetChanged();


            }
        }





    }

private void initData() {


        userList = new ArrayList<>();
        userList.add(new ModelClass(false, "Visit Las Vegas",
                "Ashmita's bucket list is to visit Las Vegas during her birthday week and have fun birthday",
                 "35.67",
                "23.32","08-02-2021"));

        userList.add(new ModelClass(false,"Graduate in Fall 2021",
                "We both are almost done with our degree and wish to graduate in fall 2021 and start working",
                "12.21",
                "23.24",
                "15-12-2021"));


        //userList.add(new ModelClass(title, description,
                //latitude, longitude, date));

    /*
    Collections.sort(userList, new Comparator<ModelClass>() {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @Override
        public int compare(ModelClass modelClass, ModelClass t1) {
            try {
                return simpleDateFormat.parse(modelClass.getDateTextView()).compareTo(simpleDateFormat.parse(t1.getDateTextView()));
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }
    });

     */














    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList,this, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onNoteClick(int position) {
        currentPosition = position;
        userList.get(position);
        Intent editIntent = new Intent(this, editItem.class);
        editIntent.putExtra("editTitle", userList.get(position).getTitleTextView());
        editIntent.putExtra("editDescription", userList.get(position).getDescriptionTextView());
        editIntent.putExtra("editLatitude", userList.get(position).getLatitudeTextView());
        editIntent.putExtra("editLongitude", userList.get(position).getLongitudeTextView());
        editIntent.putExtra("editDate", userList.get(position).getDateTextView());

        startActivityForResult(editIntent,edit_request_code);

    }
}