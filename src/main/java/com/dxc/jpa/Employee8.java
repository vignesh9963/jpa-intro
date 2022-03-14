package com.dxc.jpa;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee8 {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String role;
    private Double salary;

    @OneToOne(mappedBy = "employee8", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private EmployeeContactInfo3 contactInfo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId", nullable = false)
    private Department3 department3;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinTable(name = "EmployeesProjects",
            joinColumns = {
                    @JoinColumn(name = "employeeId", referencedColumnName = "id",
                            nullable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "projectId", referencedColumnName = "projectId",
                            nullable = false)})
    private Set<Project> projects = new HashSet<>();

    public Employee8() {
    }

    public Employee8(String firstName, String lastName,
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

    public EmployeeContactInfo3 getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(EmployeeContactInfo3 contactInfo) {
        if (contactInfo == null) {
            if (this.contactInfo != null) {
                this.contactInfo.setEmployee8(null);
            }
        }
        else {
            contactInfo.setEmployee8(this);
        }

        this.contactInfo = contactInfo;
    }

    public Department3 getDepartment3() {
        return department3;
    }

    public void setDepartment3(Department3 department3) {
        this.department3 = department3;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }

    public Set<Project> getProjects(){
        return this.projects;
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