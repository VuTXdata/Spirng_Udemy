package com.vuhocspring.review_binding_data.model;

public class Student {
    public String firstName;
    public String lastName;
    public String favoriteLanguages;
    public String operatingSystem;
    public String country;

    public Student() {
    }

    public Student(String firstName, String lastName, String favoriteLanguages, String operatingSystem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteLanguages = favoriteLanguages;
        this.operatingSystem = operatingSystem;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteLanguages() {
        return favoriteLanguages;
    }

    public void setFavoriteLanguages(String favoriteLanguages) {
        this.favoriteLanguages = favoriteLanguages;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
