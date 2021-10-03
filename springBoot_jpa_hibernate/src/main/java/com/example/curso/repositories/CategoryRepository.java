package com.example.curso.repositories;

import com.example.curso.entities.Category;
import com.example.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
