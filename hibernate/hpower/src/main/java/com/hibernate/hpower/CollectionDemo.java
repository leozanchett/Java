package com.hibernate.hpower;

import com.hibernate.hpower.models.Address;
import com.hibernate.hpower.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Address address_1 = new Address();
        Address address_2 = new Address();
        Address address_3 = new Address();

        address_1.setCity("New York");
        address_1.setState("NY");
        address_1.setPin(12345);
        address_1.setStreet("1st Avenue");

        address_2.setCity("Panaji");
        address_2.setState("Goa");
        address_2.setPin(12345);
        address_2.setStreet("18th June Road");

        address_3.setCity("Mumbai");
        address_3.setState("Maharashtra");
        address_3.setPin(12345);
        address_3.setStreet("3st Avenue");

        // instantiate a collection of addresses
        Collection<Address> addresses = Arrays.asList(address_1, address_2, address_3);

        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("John");
        employee.setListOfAddress(addresses);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        Employee temp = null;
        session = sessionFactory.openSession();
        session.beginTransaction();
        temp = session.get(Employee.class, 1);
        System.out.println("ID : " + temp.getEmpId());
        System.out.println("Name : " + temp.getEmpName());
        session.getTransaction().commit();
        session.close();
        System.out.println("List of Address : " + temp.getListOfAddress().size());
    }
}
