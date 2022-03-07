package com.dxc.jpa;

import javax.persistence.*;

@Entity
public class Employee7 {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    @OneToOne(mappedBy = "employee7", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private EmployeeContactInfo2 contactInfo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId", nullable = false)
    private Department2 department2;

    public Employee7() {
    }

    public Employee7(String firstName, String lastName,
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

    public EmployeeContactInfo2 getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(EmployeeContactInfo2 contactInfo) {
        if (contactInfo == null) {
            if (this.contactInfo != null) {
                this.contactInfo.setEmployee7(null);
            }
        }
        else {
            contactInfo.setEmployee7(this);
        }

        this.contactInfo = contactInfo;
    }

    public Department2 getDepartment2() {
        return department2;
    }

    public void setDepartment2(Department2 department2) {
        this.department2 = department2;
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