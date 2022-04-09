package com.hibernate.hpower.essentialExamples.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    @ManyToMany(mappedBy= "employeeCollection", cascade = CascadeType.PERSIST)
    private Collection<Flat> flatCollection;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Collection<Flat> getFlatCollection() {
        return flatCollection;
    }

    public void setFlatCollection(Collection<Flat> flatCollection) {
        this.flatCollection = flatCollection;
    }
}
