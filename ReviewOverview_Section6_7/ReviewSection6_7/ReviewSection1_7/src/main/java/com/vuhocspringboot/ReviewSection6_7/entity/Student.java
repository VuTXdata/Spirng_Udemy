package com.vuhocspringboot.ReviewSection6_7.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Not blank!")
    @Size(min = 5, message = "Least 5 characters")
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "Not blank!")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email phải thuộc miền @gmail.com")
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @NotNull(message = "Not blank!")
    @Min(value = 1, message = "1-4")
    @Max(value = 5, message = "1-4")
    @Column(name = "semester")
    private Integer semester;

    public Student() {
    }

    public Student(Integer id, String fullName, String email, String address, Integer semester) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.semester = semester;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
