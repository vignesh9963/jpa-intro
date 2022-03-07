package com.dxc.jpa;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String name;
    private String location;

    @OneToMany(mappedBy = "department2", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Employee7> employees;


    public Department2() {
    }

    public Department2(String name, String location) {

        this.name = name;
        this.location = location;
    }


    public Long getId() {
        return departmentId;
    }

    public void setId(Long id) {
        this.departmentId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}