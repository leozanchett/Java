package com.hibernate.hpower.inheritance.singleTableDemo.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "empType")
//@DiscriminatorValue(value = "e")
public class Employee {
    @Id
    private int empId;
    private String empName;
    private String empAddress;


    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

}
