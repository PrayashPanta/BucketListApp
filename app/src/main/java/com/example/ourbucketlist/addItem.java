package com.example.ourbucketlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;


import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class addItem extends AppCompatActivity implements View.OnClickListener{


    private EditText editTextTitle;
    private EditText editTextDescription;
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    private EditText editTextDate;



    Toolbar toolbar;

    Button btnDatePicker;
    EditText txtDate;
    private int mYear, mMonth, mDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        toolbar = (Toolbar) findViewById(R.id.addItemToolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnDatePicker = (Button) findViewById(R.id.btn_date);
        txtDate = (EditText) findViewById(R.id.txtAddDate);
        btnDatePicker.setOnClickListener(this);


        editTextTitle = findViewById(R.id.txtAddTitle);
        editTextDescription = findViewById(R.id.txtAddDec);
        editTextLatitude = findViewById(R.id.txtAddLat);
        editTextLongitude = findViewById(R.id.txtAddLon);
        editTextDate = findViewById(R.id.txtAddDate);


        Button saveList = (Button) findViewById(R.id.btnSubmit);
        saveList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextTitle.getText().equals("")
                || editTextDescription.getText().equals("") || editTextLatitude.getText().equals("")
                || editTextLongitude.getText().equals("") || editTextDate.getText().equals("")){
                    Toast.makeText(addItem.this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
                }

                else{
                    String title = editTextTitle.getText().toString();
                    String description = editTextDescription.getText().toString();
                    String latitude = editTextLatitude.getText().toString();
                    String longitude = editTextLongitude.getText().toString();
                    String date = editTextDate.getText().toString();

                    Intent intent = new Intent(addItem.this, MainActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("description", description);
                    intent.putExtra("latitude",latitude);
                    intent.putExtra("longitude", longitude);
                    intent.putExtra("date", date);
                    startActivityForResult(intent,1);

                }
            }
        });





    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                txtDate.setText(i2 + "-" + (i1 + 1) + "-" + i);

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
            }
        }

