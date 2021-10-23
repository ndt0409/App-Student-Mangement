package com.ndt.appstudentmanagement.model;

public class Subject {
    //id các môn học
    private int id;
    //tên môn học
    private String subject_title;
    //số tín chỉ
    private int number_of_credit;
    //thời gian học
    private String time;
    //địa điểm
    private String place;

    public Subject(String subject_title, int number_of_credit, String time, String place) {
        this.subject_title = subject_title;
        this.number_of_credit = number_of_credit;
        this.time = time;
        this.place = place;
    }

    public Subject(int id, String subject_title, int number_of_credit, String time, String place) {
        this.id = id;
        this.subject_title = subject_title;
        this.number_of_credit = number_of_credit;
        this.time = time;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject_title() {
        return subject_title;
    }

    public void setSubject_title(String subject_title) {
        this.subject_title = subject_title;
    }

    public int getNumber_of_credit() {
        return number_of_credit;
    }

    public void setNumber_of_credit(int number_of_credit) {
        this.number_of_credit = number_of_credit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
