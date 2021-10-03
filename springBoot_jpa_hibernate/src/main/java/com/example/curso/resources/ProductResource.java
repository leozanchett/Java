package com.example.curso.resources;

import com.example.curso.entities.Product;
import com.example.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    
    @Autowired
    ProductService prdService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(prdService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(prdService.findById(id));
    }
}
