package com.hibernate.hpower.inheritance;

import com.hibernate.hpower.inheritance.singleTableDemo.models.ContractualEmployee;
import com.hibernate.hpower.inheritance.singleTableDemo.models.Employee;
import com.hibernate.hpower.inheritance.singleTableDemo.models.RegularEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingleTableDemo {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setEmpName("John");
        employee.setEmpId(1);
        employee.setEmpName("John");
        employee.setEmpAddress("Bangalore");

        RegularEmployee regularEmployee = new RegularEmployee();
        regularEmployee.setEmpId(2);
        regularEmployee.setEmpName("Priyesh");
        regularEmployee.setEmpAddress("Mumbai");
        regularEmployee.setBasic(40000);
        regularEmployee.calculateSalary();

        ContractualEmployee contractualEmployee = new ContractualEmployee();
        contractualEmployee.setEmpId(3);
        contractualEmployee.setEmpName("Rajesh");
        contractualEmployee.setEmpAddress("Delhi");
        contractualEmployee.setConsolidatePay(75000);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.save(regularEmployee);
        session.save(contractualEmployee);
        session.getTransaction().commit();
        session.close();

    }
}
