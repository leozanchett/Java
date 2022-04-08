package com.hibernate.hpower;

import com.hibernate.hpower.models.Address;
import com.hibernate.hpower.models.Employe;
import com.hibernate.hpower.models.EmployeeId;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Date;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HpowerApplication {


    public static void main(String[] args) {
        SpringApplication.run(HpowerApplication.class, args);
        System.out.println("EntityIdDemo");
        // Address address = new Address();
        Address address = new Address();
        address.setCity("Panaji");
        address.setState("Goa");
        address.setStreet("Temple");
        address.setPin(403001);

        // EmployeeId entityId
        EmployeeId entityId = new EmployeeId();
        entityId.setEmpId(1);
        entityId.setDepartment("Finance");

        EmployeeId entityId2 = new EmployeeId();
        entityId2.setEmpId(1);
        entityId2.setDepartment("Marketing");

        // Employee entity = new Employee();
        Employe e1 = new Employe();
        e1.setEmployeId(entityId);
        e1.setEmpName("Raj");
        e1.setEmpAddress("Hyderabad");
        // set date with local format
        e1.setEmpDoj(new Date());
        e1.setEmpAddressObj(address);

        Employe e2 = new Employe();
        e2.setEmployeId(entityId2);
        e2.setEmpName("Maj");
        e2.setEmpAddress("Chandigarh");
        // set date with local format
        e2.setEmpDoj(new Date());
        e2.setEmpAddressObj(address);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(e1);
            session.save(e2);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        Employe temp1, temp2;
        session = sessionFactory.openSession();
        session.beginTransaction();
        temp1 = session.get(Employe.class, entityId);
        temp2 = session.get(Employe.class, entityId2);
        System.out.println(temp1.toString());
        System.out.println(temp2.toString());
    }

}
