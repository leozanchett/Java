package com.hibernate.hpower.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee_one_to_one {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    @OneToOne
    private Flat flat;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
