package com.ty.foodjoint.dao;

import java.util.List;

import com.ty.foodjoint.dto.Product;

public interface ProductDao {
	public Product save(Product product);
	public Product getbyid(int id);
	public List<Product> getall();
	public Product update(int id,Product product);
	public boolean delete(int id);
	public List<Product> getByType(String type);

}
