package com.hibernate.hpower.inheritance.singleTableDemo.models;

import javax.persistence.Entity;

@Entity
//@DiscriminatorColumn(name="empType")
//@DiscriminatorValue(value = "ce")
public class ContractualEmployee extends Employee {
    private double consolidatePay;

    public void setConsolidatePay(double consolidatePay) {
        this.consolidatePay = consolidatePay;
    }
}
