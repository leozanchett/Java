package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee;
import com.hibernate.hpower.models.Flat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneUniDemo {
    public static void main(String[] args) {
        Flat flat = new Flat();
        flat.setFlatId(1);
        flat.setFlatNo("A-1");
        flat.setApartmentName("Anantdhara");
        flat.setNoOfBedrooms(3);

        Employee employee = new Employee();
        employee.setEmpId(1);
        employee.setEmpName("Raj");
        employee.setEmpAddress("Pune");
        employee.setFlat(flat);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(employee);
            session.save(flat);
            session.getTransaction().commit();
            Employee employeRequest;
            employeRequest = session.get(Employee.class, 1);
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
