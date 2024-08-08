package com.vuhocspring.validated_data.model;

import com.vuhocspring.validated_data.validate.CourseCode;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {
    private String firstName;

    @NotNull(message = "khong de trong")
    @Size(min = 2, message = "toi thieu 2 ky tu")
    private String lastName;

    @NotNull(message = "khong de trong")
    @Min(value = 1, message = "toi thieu 1")
    @Max(value = 10, message = "toi da 10")
    private Integer count;

    @NotNull(message = "khong de trong")
    @CourseCode
    private String courseCode;

    public Customer(String firstName, String lastName, Integer count, String courseCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.count = count;
        this.courseCode = courseCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Customer() {

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
}
