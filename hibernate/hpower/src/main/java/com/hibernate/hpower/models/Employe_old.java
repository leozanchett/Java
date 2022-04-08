package com.hibernate.hpower.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Employe_old implements Serializable {
    @EmbeddedId
    private EmployeeId employeId;
    private String empName;
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


    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public void setEmpDoj(Date empDoj) {
        this.empDoj = empDoj;
    }

    public void setEmpAddressObj(Address empAddressObj) {
        this.empAddressObj = empAddressObj;
    }

    public void setEmployeId(EmployeeId employeId) {
        this.employeId = employeId;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "employeId=" + employeId.getEmpId() +
                ", employeIdDepartment='" + employeId.getDepartment() + '\'' +
                ", empName='" + empName + '\'' +
                ", empAddress='" + empAddress + '\'' +
                ", empDoj=" + empDoj +
                ", empAge=" + empAge +
                ", empAddressObj=" + empAddressObj +
                '}';
    }
}
