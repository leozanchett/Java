package com.example.curso.resources;

import com.example.curso.entities.Category;
import com.example.curso.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	CategoryService usrService;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok().body(usrService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(usrService.findById(id));
	}
}
