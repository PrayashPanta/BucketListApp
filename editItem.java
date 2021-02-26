package com.example.ourbucketlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

public class editItem extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;

    Button btnDatePicker, btnSubmit;
    EditText txtDate;
    private int mYear, mMonth, mDay;

    TextView title,description,latitude,longitude,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        toolbar = (Toolbar) findViewById(R.id.addItemToolBar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        txtDate = (EditText) findViewById(R.id.txtAddDate);
        btnDatePicker.setOnClickListener(this);


        title = (TextView) findViewById(R.id.editTitle);
        description = (TextView) findViewById(R.id.editDec);
        latitude = (TextView) findViewById(R.id.editLat);
        longitude = (TextView) findViewById(R.id.editLon);
        date = (TextView) findViewById(R.id.editDate);





        title.setText(getIntent().getStringExtra("editTitle"));
       description.setText(getIntent().getStringExtra("editDescription"));
       latitude.setText(getIntent().getStringExtra("editLatitude"));
       longitude.setText(getIntent().getStringExtra("editLongitude"));
       date.setText(getIntent().getStringExtra("editDate"));


       btnSubmit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String editTitle = title.getText().toString();
               String editDescription = description.getText().toString();
               String editLatitude = latitude.getText().toString();
               String editLongitude = longitude.getText().toString();
               String editDate = date.getText().toString();

               if (editTitle.matches("")
                       || editDescription.matches("") || editLatitude.matches("")
                       || editLongitude.matches("") || editDate.matches("")){
                   Toast.makeText(editItem.this, "Please Enter All Data", Toast.LENGTH_SHORT).show();
                   return;
               }

               else{

                   Intent intent = new Intent();
                   intent.putExtra("newTitle", editTitle);
                   intent.putExtra("newDescription", editDescription);
                   intent.putExtra("newLatitude",editLatitude);
                   intent.putExtra("newLongitude", editLongitude);
                   intent.putExtra("newDate", editDate);
                   setResult(RESULT_OK,intent);
                   finish();
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

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                date.setText(i2 + "-" + (i1 + 1) + "-" + i);

            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
    }
