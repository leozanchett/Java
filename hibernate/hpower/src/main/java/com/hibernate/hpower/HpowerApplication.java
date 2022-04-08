package com.hibernate.hpower;

import com.hibernate.hpower.models.Employe;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HpowerApplication {


    public static void main(String[] args) {
        SpringApplication.run(HpowerApplication.class, args);
        System.out.println("EntityIdDemo");
        Employe e1 = new Employe();
        e1.setEmpId(1);
        e1.setEmpName("Raj");
        e1.setEmpAddress("Hyderabad");
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(e1);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
