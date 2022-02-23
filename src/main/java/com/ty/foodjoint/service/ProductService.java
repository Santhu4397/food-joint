package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.util.ResponseStructure;

public interface ProductService {
	public ResponseEntity<ResponseStructure<Product>> save(Product product);

	public ResponseEntity<ResponseStructure<Product>> getbyid(int id);

	public ResponseEntity<ResponseStructure<List<Product>>> getall();

	public ResponseEntity<ResponseStructure<Product>> update(int id, Product product);

	public ResponseEntity<ResponseStructure<String>> delete(int id);

	public ResponseEntity<ResponseStructure<List<Product>>> getByType(String type);

}
