package com.dxc.jpa;

import javax.persistence.*;

@Entity
public class Employee6 {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    @OneToOne(mappedBy = "employee6", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = true)
    private EmployeeContactInfo contactInfo;

    public Employee6() {
    }

    public Employee6(String firstName, String lastName,
                    String role, Double salary) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(EmployeeContactInfo contactInfo) {
        if (contactInfo == null) {
            if (this.contactInfo != null) {
                this.contactInfo.setEmployee6(null);
            }
        }
        else {
            contactInfo.setEmployee6(this);
        }

        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {

        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", contactInfo=" + contactInfo +
                '}';
    }
}