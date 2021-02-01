package com.example.ourbucketlist;

public class ModelClass {

    private String titleTextView;
    private String descriptionTextView;
    private String latitudeTextView;
    private String longitudeTextView;
    private String dateTextView;



    ModelClass(String titleTextView, String descriptionTextView, String latitudeTextView, String longitudeTextView, String dateTextView){
        this.titleTextView = titleTextView;
        this.descriptionTextView = descriptionTextView;
        this.latitudeTextView = latitudeTextView;
        this.longitudeTextView = longitudeTextView;
        this.dateTextView = dateTextView;
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
}
