package com.stefanini.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stefanini.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
		
}
