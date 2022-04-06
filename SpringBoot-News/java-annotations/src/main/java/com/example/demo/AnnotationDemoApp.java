package src.main.java.com.example.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		com.example.demo.Coach theCoach = context.getBean("thatSillyCoach", com.example.demo.Coach.class);
		
		// call a method on the beanO
		System.out.println(theCoach.getDailyWorkout());
				
		// close the context
		context.close();
	}

}


