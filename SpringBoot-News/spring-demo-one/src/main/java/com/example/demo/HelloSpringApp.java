package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
   public static void main(String[] args) {
      // load the spring configuration file
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

      // retrieve bean from sprint container
      Coach theCoach = context.getBean("myCoach2", Coach.class);

      // call methos on the bean
      System.out.println(theCoach.getDailyWorkout());

      // close the context
      context.close();

   }

}
