package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee;
import com.hibernate.hpower.models.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ManyToManyBiDemo {
    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setEmpId(6);
        employee.setEmpName("Anant");
        employee.setEmpAddress("Kathmandu");

        Employee employee1 = new Employee();
        employee1.setEmpId(7);
        employee1.setEmpName("Anant1");
        employee1.setEmpAddress("Kathmandu1");

        Employee employee2 = new Employee();
        employee2.setEmpId(8);
        employee2.setEmpName("Anant2");
        employee2.setEmpAddress("Kathmandu2");

        Flat flat = new Flat();
        flat.setFlatId(1);
        flat.setFlatNo("A-1");
        flat.setApartmentName("Anantdhara");
        flat.setNoOfBedrooms(1);

        Flat flat1 = new Flat();
        flat1.setFlatId(2);
        flat1.setFlatNo("A-2");
        flat1.setApartmentName("Anantdhara");
        flat1.setNoOfBedrooms(2);

        Flat flat2 = new Flat();
        flat2.setFlatId(3);
        flat2.setFlatNo("A-3");
        flat2.setApartmentName("Anantdhara");
        flat2.setNoOfBedrooms(3);

        employee.setFlatCollection(Arrays.asList(flat, flat1, flat2));
        employee1.setFlatCollection(Arrays.asList(flat, flat1, flat2));
        employee2.setFlatCollection(Arrays.asList(flat, flat1, flat2));
        flat.setEmployeeCollection(Arrays.asList(employee, employee1, employee2));
        flat1.setEmployeeCollection(Arrays.asList(employee, employee1, employee2));
        flat2.setEmployeeCollection(Arrays.asList(employee, employee1, employee2));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employee);
            session.save(employee1);
            session.save(employee2);
            session.save(flat);
            session.save(flat1);
            session.save(flat2);
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
