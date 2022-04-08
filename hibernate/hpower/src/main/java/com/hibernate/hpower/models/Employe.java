package com.hibernate.hpower.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employe {
    @Id
    private Long empId;
    private String empName;
    private String empAddress;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }
}
