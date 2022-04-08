package com.hibernate.hpower.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employe implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String empName;
    private String empAddress;
    @Id
    private String department;
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

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmpDoj(Date empDoj) {
        this.empDoj = empDoj;
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
                ", department='" + department + '\'' +
                ", empDoj=" + empDoj +
                ", empAge=" + empAge +
                ", empAddressObj=" + empAddressObj +
                '}';
    }
}
