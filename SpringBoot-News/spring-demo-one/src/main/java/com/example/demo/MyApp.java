package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
   public static void main(String[] args) {
      // create the object
      Coach theCoach = new TrackCoach();
      // use the object
      System.out.println(theCoach.getDailyWorkout());
      // create a spring container
      try {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         // retrieve bean from spring container
         Coach theCoach2 = context.getBean("myCoach", Coach.class);
         System.out.println(theCoach2.getDailyWorkout());
      } finally {
      
      }
   }
}
