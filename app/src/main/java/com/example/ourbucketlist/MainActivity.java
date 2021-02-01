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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter adapter;
    private FloatingActionButton floatingbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();


        floatingbutton = (FloatingActionButton) findViewById(R.id.fab);
        floatingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddItem();
            }
        });








    }
    public void openAddItem(){
        Intent intent = new Intent(this,addItem.class);
        startActivity(intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==1 ){
            String title= data.getStringExtra("title");
            String description = data.getStringExtra("description");

            userList.add(new ModelClass(title, description,"","",""));
            adapter.notifyDataSetChanged();
        }
    }

    private void initData() {
        Intent intent1 = getIntent();
        String title = intent1.getStringExtra("title");
        String description = intent1.getStringExtra("description");
        String latitude = intent1.getStringExtra("latitude");
        String longitude = intent1.getStringExtra("longitude");
        String date = intent1.getStringExtra("date");


        userList = new ArrayList<>();
        userList.add(new ModelClass("Title: " + "Visit Las Vegas",
                "Description: " + "Ashmita's bucket list is to visit Las Vegas during her birthday week and have fun birthday",
                "Latitude: " + "35.67",
                "Longitude: " + "23.32","Date: " + "08-02-2021"));

        userList.add(new ModelClass("Title: " + "Graduate in Fall 2021",
                "Description: " +"We both are almost done with our degree and wish to graduate in fall 2021 and start working",
                "Latitude: " + "12.21",
                "Longitude: " +"23.24",
                "Date: " + "15-12-2021"));

        userList.add(new ModelClass(title, description,
                latitude, longitude, date));


    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);

    }
}