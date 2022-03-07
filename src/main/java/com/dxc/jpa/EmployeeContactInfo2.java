package com.dxc.jpa;

import javax.persistence.*;

@Entity
public class EmployeeContactInfo2 {

    @Id
    private Long id;

    private String address;
    private String phoneNum;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee7 employee7;

    public EmployeeContactInfo2() {
    }

    public EmployeeContactInfo2(String address, String phoneNum) {

        this.address = address;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Employee7 getEmployee7() {
        return employee7;
    }

    public void setEmployee7(Employee7 employee7) {
        this.employee7 = employee7;
    }

    @Override
    public String toString() {
        return "EmployeeContactInfo{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}