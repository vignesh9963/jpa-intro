package com.dxc.jpa;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Embeddable
public class EmployeeEntryId implements Serializable {

    private int employeeId;
    private LocalDate entryDate;

    public EmployeeEntryId() {
    }

    public EmployeeEntryId(int employeeId, LocalDate entryDate) {
        this.employeeId = employeeId;
        this.entryDate = entryDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }


    @Override
    public boolean equals(Object obj) {

        if(this == obj){
            return true;
        }

        if (!(obj instanceof EmployeeEntryId)) {
            return false;
        }
        EmployeeEntryId entryId = (EmployeeEntryId) obj;

        return ((entryId.getEmployeeId() == this.getEmployeeId()) &&
                (this.getEntryDate().equals(entryId.getEntryDate())));

    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, entryDate);
    }



}
