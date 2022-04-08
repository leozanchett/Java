package com.hibernate.hpower;

import com.hibernate.hpower.models.Employee;
import com.hibernate.hpower.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HpowerApplication {

	@Autowired
	private EmployeRepository employeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HpowerApplication.class, args);
		System.out.println("EntityIdDemo");
		Employee e1 = new Employee();
		e1.setEmpId(1);
		e1.setEmpName("Raj");
		e1.setEmpAddress("Hyderabad");
		employeRepository.save(e1);

	}

}
