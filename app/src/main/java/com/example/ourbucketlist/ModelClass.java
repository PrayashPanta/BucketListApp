package com.example.ourbucketlist;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelClass implements Comparable<ModelClass>, Serializable {

    private String titleTextView;
    private String descriptionTextView;
    private String latitudeTextView;
    private String longitudeTextView;
    private String dateTextView;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    ModelClass(boolean isChecked,String titleTextView, String descriptionTextView, String latitudeTextView, String longitudeTextView, String dateTextView){
        this.titleTextView = titleTextView;
        this.descriptionTextView = descriptionTextView;
        this.latitudeTextView = latitudeTextView;
        this.longitudeTextView = longitudeTextView;
        this.dateTextView = dateTextView;
        this.isChecked = isChecked;
    }

    public String getTitleTextView() {
        return titleTextView;
    }

    public String getDescriptionTextView() {
        return descriptionTextView;
    }

    public String getLatitudeTextView() {
        return latitudeTextView;
    }

    public String getLongitudeTextView() {
        return longitudeTextView;
    }

    public String getDateTextView() {
        return dateTextView;
    }

    public void setTitleTextView(String titleTextView) {
        this.titleTextView = titleTextView;
    }

    public void setDescriptionTextView(String descriptionTextView) {
        this.descriptionTextView = descriptionTextView;
    }

    public void setLatitudeTextView(String latitudeTextView) {
        this.latitudeTextView = latitudeTextView;
    }

    public void setLongitudeTextView(String longitudeTextView) {
        this.longitudeTextView = longitudeTextView;
    }

    public void setDateTextView(String dateTextView) {
        this.dateTextView = dateTextView;
    }


    @Override
    public int compareTo(ModelClass modelClass) {
        try {
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(getDateTextView());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(modelClass.getDateTextView());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
