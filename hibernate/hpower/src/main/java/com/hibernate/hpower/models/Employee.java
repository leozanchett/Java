package com.hibernate.hpower.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Collection;

@Entity
public class Employee {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    @OneToMany(mappedBy = "employee") // evitar criar uma terceira tabela associativa
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
