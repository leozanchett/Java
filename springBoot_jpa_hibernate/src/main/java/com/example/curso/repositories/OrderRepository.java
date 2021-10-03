package com.example.curso.repositories;

import com.example.curso.entities.Order;
import com.example.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
