package com.hibernate.hpower.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    @Column(name = "name")
    private String empName;
    @Column(name = "address")
    private String empAddress;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date empDoj;
    @Transient
    private int empAge;
    @Embedded
    @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET"))
    @AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY"))
    @AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE"))
    @AttributeOverride(name = "pin", column = @Column(name = "OFFICE_PIN"))
    private Address empAddressObj;

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public Date getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(Date empDoj) {
        this.empDoj = empDoj;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public Address getEmpAddressObj() {
        return empAddressObj;
    }

    public void setEmpAddressObj(Address empAddressObj) {
        this.empAddressObj = empAddressObj;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empDoj=" + empDoj +
                ", empAge=" + empAge +
                '}';
    }
}
