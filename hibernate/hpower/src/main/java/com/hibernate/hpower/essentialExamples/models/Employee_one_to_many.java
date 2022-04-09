package com.hibernate.hpower.essentialExamples.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Employee_one_to_many {
    @Id
    private int empId;
    private String empName;
    private String empAddress;
    @OneToMany(mappedBy = "employee") // evitar criar uma terceira tabela associativa
    private Collection<Flat_many_to_one> flatManytooneCollection;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Collection<Flat_many_to_one> getFlatCollection() {
        return flatManytooneCollection;
    }

    public void setFlatCollection(Collection<Flat_many_to_one> flatManytooneCollection) {
        this.flatManytooneCollection = flatManytooneCollection;
    }
}
