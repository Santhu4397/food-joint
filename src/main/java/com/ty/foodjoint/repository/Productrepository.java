package com.ty.foodjoint.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodjoint.dto.Product;

public interface Productrepository extends JpaRepository<Product, Integer>{

	 public List<Product> findByType(String type);
}
