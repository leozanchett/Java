package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee_one_to_many;
import com.hibernate.hpower.models.Flat_many_to_one;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.Collection;

public class OneToManyUniDemo {
    public static void main(String[] args) {
        Flat_many_to_one flatManytoone = new Flat_many_to_one();
        flatManytoone.setFlatId(1);
        flatManytoone.setFlatNo("A-1");
        flatManytoone.setApartmentName("Anantdhara");
        flatManytoone.setNoOfBedrooms(1);

        Flat_many_to_one flatManytoone2 = new Flat_many_to_one();
        flatManytoone2.setFlatId(2);
        flatManytoone2.setFlatNo("A-2");
        flatManytoone2.setApartmentName("Anantdhara");
        flatManytoone2.setNoOfBedrooms(2);

        Flat_many_to_one flatManytoone3 = new Flat_many_to_one();
        flatManytoone3.setFlatId(3);
        flatManytoone3.setFlatNo("A-3");
        flatManytoone3.setApartmentName("Anantdhara");
        flatManytoone3.setNoOfBedrooms(3);

        Collection<Flat_many_to_one> flatManytoones = Arrays.asList(flatManytoone, flatManytoone2, flatManytoone3);

        Employee_one_to_many employee = new Employee_one_to_many();
        employee.setEmpId(1);
        employee.setEmpName("Raj");
        employee.setEmpAddress("Pune");
        employee.setFlatCollection(flatManytoones);
        

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employee);
            session.save(flatManytoone);
            session.save(flatManytoone2);
            session.save(flatManytoone3);
            session.getTransaction().commit();
            Employee_one_to_many employeRequest = session.get(Employee_one_to_many.class, 1);
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
