package com.hibernate.hpower.models;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    @ElementCollection
    @JoinTable(name = "emp_address", joinColumns = @JoinColumn(name = "emp_id"))
    @GenericGenerator(name = "myGenerator", strategy = "increment")
    @CollectionId(column = @Column(name = "address_id"), type = @Type(type = "long"), generator = "myGenerator")
    private Collection<Address> listOfAddress;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setListOfAddress(Collection<Address> listOfAddress) {
        this.listOfAddress = listOfAddress;
    }
}
