package com.example.curso.resources;

import com.example.curso.entities.OrderItem;
import com.example.curso.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderitem")
public class OrderItemResource {

	@Autowired
	OrderItemService OrderItemService;

	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll() {
		return ResponseEntity.ok().body(OrderItemService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(OrderItemService.findById(id));
	}
}
