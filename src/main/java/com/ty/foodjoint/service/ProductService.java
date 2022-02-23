package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.util.ResponseStructuer;

public interface ProductService {
	public ResponseEntity<ResponseStructuer<Product>> save(Product product);
	public ResponseEntity<ResponseStructuer<Product>> getbyid(int id);
	public ResponseEntity<ResponseStructuer<List<Product>>> getall();
	public ResponseEntity<ResponseStructuer<Product>> update(int id,Product product);
	public ResponseEntity<ResponseStructuer<String>> delete(int id);
	public ResponseEntity<ResponseStructuer<List<Product>>> getByType(String type);

}
