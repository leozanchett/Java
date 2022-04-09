package com.hibernate.hpower.essentialExamples.models;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
public class Employee_withCollections {
    @Id
    private int empId;
    private String empName;
    @ElementCollection(fetch = FetchType.EAGER) // por default um element collection é lazy, isso quer dizer que ao efetuar uma consulta no banco pelo Employee,
                                                // ele não irá trazer os dados do element collection, apenas o id. Se eu colocar o fetch = FetchType.EAGER, ele irá trazer os dados do element collection
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

    public Collection<Address> getListOfAddress() {
        return listOfAddress;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }
}
