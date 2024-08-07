package com.vuhocspring.thymeleafdemo.model;

public class Student {
    public String firstName;
    public String lastName;
    public String country;
    public String favorite;
    public String OSys;
    public Student() {
    }

    public Student(String firstName, String lastName, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;

    }

    public String getOSys() {
        return OSys;
    }

    public void setOSys(String OSys) {
        this.OSys = OSys;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
