package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee_one_to_one;
import com.hibernate.hpower.models.Flat_many_to_one;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniDemo {
    public static void main(String[] args) {
        Flat_many_to_one flatManytoone = new Flat_many_to_one();
        flatManytoone.setFlatId(1);
        flatManytoone.setFlatNo("A-1");
        flatManytoone.setApartmentName("Anantdhara");
        flatManytoone.setNoOfBedrooms(3);

        Employee_one_to_one employeeOnetoone = new Employee_one_to_one();
        employeeOnetoone.setEmpId(1);
        employeeOnetoone.setEmpName("Raj");
        employeeOnetoone.setEmpAddress("Pune");
        employeeOnetoone.setFlat(flatManytoone);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employeeOnetoone);
            session.save(flatManytoone);
            session.getTransaction().commit();
            Employee_one_to_one employeRequest;
            employeRequest = session.get(Employee_one_to_one.class, 1);
            System.out.println(employeRequest.getFlat().toString());
        }catch (Exception e){
            e.printStackTrace();
            if(session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }finally {
            session.close();
        }
    }
}
