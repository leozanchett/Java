package com.hibernate.hpower.inheritance.singleTableDemo.models;

import javax.persistence.Entity;

@Entity
//@DiscriminatorColumn(name="empType")
//@DiscriminatorValue(value = "re")
public class RegularEmployee extends Employee {
    private double basic;
    private double da;
    private double hra;
    private double salary;

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculateSalary() {
        this.da = 0.5 * this.basic;
        this.hra = 0.25 * this.basic;
        this.salary = basic + da + hra;
    }
}
