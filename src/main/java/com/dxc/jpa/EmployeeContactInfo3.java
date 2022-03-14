package com.dxc.jpa;

import javax.persistence.*;

@Entity
public class EmployeeContactInfo3 {

    @Id
    private Long id;

    private String address;
    private String phoneNum;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee8 employee8;

    public EmployeeContactInfo3() {
    }

    public EmployeeContactInfo3(String address, String phoneNum) {

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

    public Employee8 getEmployee8() {
        return employee8;
    }

    public void setEmployee8(Employee8 employee8) {
        this.employee8 = employee8;
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