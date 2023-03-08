package com.example.restwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restwebservices.bean.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
