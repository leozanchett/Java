package com.hibernate.hpower.models;

import java.io.Serializable;

public class EmployeeId implements Serializable {
    private int empId;
    private String department;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
