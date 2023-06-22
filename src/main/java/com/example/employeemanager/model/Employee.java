package com.example.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
//Serializable helps transform the java class into different types of stream, because this class
//is going to be saved in a database then it will be sent to the front as json
@Entity // this class is going to be mapped to the configured database on the class path
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue, specify how the primary key values of database entities should be generated.
    //The IDENTITY strategy corresponds to  instructing the ORM framework to rely on the database's own identity generation mechanism for assigning primary key values to the entities.
    //For the AUTO strategy, the ORM framework will determine the most appropriate strategy for generating primary key values based on the specific database being used
    @Column(nullable = false, updatable = false) //updatable = false, the id cannot be updated
    private Long id;

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;



    public Employee(String name, String email, String jobTitle, String phone, String imageUrl, String employeeCode) {

        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhone() {
        return phone;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
