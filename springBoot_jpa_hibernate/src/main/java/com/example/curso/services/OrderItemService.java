package com.example.curso.services;

import com.example.curso.entities.OrderItem;
import com.example.curso.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;

	public List<OrderItem> findAll(){
		return repository.findAll();
	}

	public OrderItem findById(Long id) {
		Optional<OrderItem> OrderItem = repository.findById(id);
		return OrderItem.get();
	}
}
