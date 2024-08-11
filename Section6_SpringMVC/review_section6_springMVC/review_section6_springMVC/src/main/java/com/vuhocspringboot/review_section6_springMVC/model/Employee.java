package com.vuhocspringboot.review_section6_springMVC.model;

import jakarta.validation.constraints.*;

public class Employee {

    @NotNull(message = "not blank")
    @Size(min = 8, message = "least 8 characters")
    private String firstName;

    @NotNull(message = "not blank")
    @Size(min = 8, message = "least 8 characters")
    private String lastName;

    @NotNull(message = "not blank")
    @Min(value = 16, message = "least 16 up to")
    private Integer age;

    private String chucVu;

    @Pattern(regexp = "0\\d{11}]", message = "Phone number must be 12 digits and start with 0")
    private String phone;

    private String loaiCv;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Integer age, String chucVu, String phone, String loaiCv) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.chucVu = chucVu;
        this.phone = phone;
        this.loaiCv = loaiCv;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoaiCv() {
        return loaiCv;
    }

    public void setLoaiCv(String loaiCv) {
        this.loaiCv = loaiCv;
    }
}
