package com.ty.foodjoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.service.ProductService;
import com.ty.foodjoint.util.ResponseStructuer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {
	@Autowired
	ProductService service;
	@PostMapping("product")
	@ApiOperation("tosave data of product in DB")
	@ApiResponses({@ApiResponse(code=200,message="data saved to DB"),
	@ApiResponse(code=404,message = "class not found in controller"),
	@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<Product>> save(@RequestBody Product product) {
		return service.save(product);
	}
	@GetMapping("product")
	@ApiOperation("togetall product data from DB")
	@ApiResponses({@ApiResponse(code=200,message="data save to DB"),
		@ApiResponse(code=404,message = "class not found in controller"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<List<Product>>> getall(){
		return service.getall();
		
	}
	@GetMapping("product/{id}")
	@ApiOperation(" to getdata of product by ID  from DB")
	@ApiResponses({@ApiResponse(code=200,message="data save to DB"),
		@ApiResponse(code=404,message = "class not found in controller"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<Product>> getbyid(@PathVariable int id) {
		return service.getbyid(id);
	}
	@PutMapping("product/{id}")
	@ApiOperation("update product by ID in DB")
	@ApiResponses({@ApiResponse(code=200,message="data save to DB"),
		@ApiResponse(code=404,message = "class not found in controller"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<Product>> update(@PathVariable int id,@RequestBody Product product) {
		return	service.update(id, product);
	}
	@DeleteMapping("product")
	@ApiOperation("todelete data of product in DB")
	@ApiResponses({@ApiResponse(code=200,message="data save to DB"),
		@ApiResponse(code=404,message = "class not found in controller"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<String>> delete(@RequestParam int id) {
		return service.delete(id);
	}
	
	@PostMapping("product/{type}")
	@ApiOperation("toget data of product by Type from  DB")
	@ApiResponses({@ApiResponse(code=200,message="data saved to DB"),
	@ApiResponse(code=404,message = "class not found in controller"),
	@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructuer<List<Product>>> getbytype(@PathVariable String type) {
		System.out.println(type);
		return service.getByType(type);
	}
}
