package com.dxc.jpa;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee1 {

    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String job;
    private double salary;


    public Employee1() {
    }

    public Employee1(int id, String firstName, String lastName, String job, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
