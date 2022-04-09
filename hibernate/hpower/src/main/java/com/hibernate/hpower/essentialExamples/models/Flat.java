package com.hibernate.hpower.essentialExamples.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Flat {
    @Id
    private int flatId;
    private String apartmentName;
    private String flatNo;
    private int noOfBedrooms;
    @ManyToMany//(mappedBy = "flatCollection")
    private Collection<Employee> employeeCollection;

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    public void setFlatId(int flatId) {
        this.flatId = flatId;
    }

    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setNoOfBedrooms(int noOfBedrooms) {
        this.noOfBedrooms = noOfBedrooms;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "flatId=" + flatId +
                ", apartmentName='" + apartmentName + '\'' +
                ", flatNo='" + flatNo + '\'' +
                ", noOfBedrooms=" + noOfBedrooms +
                '}';
    }
}
