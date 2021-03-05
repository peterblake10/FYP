package com.example.fyp.Model;

// Video showing me how to display database records in a listview - https://youtu.be/6q4-Ge0UMKY


import android.graphics.Bitmap;

public class Tutor {

    String prefix;
    String name;
    String surname;
    String subject;
    Bitmap image;


    public Tutor(String prefix, String name, String surname, String subject, Bitmap image) {

        this.prefix = prefix;
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.image = image;

    }



//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

}
