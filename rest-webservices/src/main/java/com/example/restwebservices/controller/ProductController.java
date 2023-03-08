package com.example.restwebservices.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restwebservices.bean.Product;
import com.example.restwebservices.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@PostMapping("/product")
	public ResponseEntity<Product> saveNewProduct(@Valid @RequestBody Product product) {

		Product newProduct = repository.save(
				new Product(product.getProduct_name(), product.getProduct_owner(), product.getProduct_quantity()));
		return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
	}

	@PostMapping("/productList")
	public ResponseEntity<List<Product>> saveNewProductList(@RequestBody List<Product> products) {

		List<Product> productList = new ArrayList<>();

		for (Product product : products) {
			productList.add(product);
		}
		repository.saveAll(productList);
		return new ResponseEntity<>(productList, HttpStatus.CREATED);
	}

	@PostMapping("/productUri")
	public ResponseEntity<Product> saveNewProductListWithLocation(@RequestBody Product products) {

		Product savedProduct = repository.save(products);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		Optional<Product> product = repository.findById(id);
		
		if(!product.isPresent()) {
			return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(product.get(),HttpStatus.FOUND);
		
		
	}

}
