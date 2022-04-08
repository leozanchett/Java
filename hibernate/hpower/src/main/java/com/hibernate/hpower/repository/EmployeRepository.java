package com.hibernate.hpower.repository;

import com.hibernate.hpower.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee, Integer> {
}
