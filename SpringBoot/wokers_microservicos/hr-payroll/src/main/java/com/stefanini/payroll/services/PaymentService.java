package com.stefanini.payroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.payroll.entities.Payment;
import com.stefanini.payroll.entities.Worker;
import com.stefanini.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
		
	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findByID(workerId).getBody();		
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
