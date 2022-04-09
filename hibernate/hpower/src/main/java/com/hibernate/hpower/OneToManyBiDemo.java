package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee;
import com.hibernate.hpower.models.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Collection;

public class OneToManyBiDemo {
    public static void main(String[] args) {

        Employee employee = new Employee();

        Flat flat = new Flat();
        flat.setFlatId(1);
        flat.setFlatNo("A-1");
        flat.setApartmentName("Anantdhara");
        flat.setNoOfBedrooms(1);
        flat.setEmployee(employee);

        Flat flat2 = new Flat();
        flat2.setFlatId(2);
        flat2.setFlatNo("A-2");
        flat2.setApartmentName("Anantdhara");
        flat2.setNoOfBedrooms(2);
        flat2.setEmployee(employee);

        Flat flat3 = new Flat();
        flat3.setFlatId(3);
        flat3.setFlatNo("A-3");
        flat3.setApartmentName("Anantdhara");
        flat3.setNoOfBedrooms(3);
        flat3.setEmployee(employee);

        employee.setEmpId(6);
        employee.setEmpName("Anant");
        employee.setEmpAddress("Kathmandu");
        employee.setFlatCollection(Arrays.asList(flat, flat2, flat3));


        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employee);
            session.save(flat);
            session.save(flat2);
            session.save(flat3);
            session.getTransaction().commit();
            Employee employeRequest = session.get(Employee.class, 6);
            System.out.println(employeRequest.getFlatCollection().toString());
        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}
