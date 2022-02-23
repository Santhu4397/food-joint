package com.ty.foodjoint.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodjoint.dao.ProductDao;
import com.ty.foodjoint.dto.Product; 

import com.ty.foodjoint.repository.Productrepository;

@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private Productrepository productrepository ;
	
	@Override
	public Product save(Product product) {
		
		return productrepository.save(product);
	}
 
	@Override
	public Product getbyid(int id) {
		
		Optional<Product> optional= productrepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Product> getall() {
		// TODO Auto-generated method stub
		return productrepository.findAll();
	}

	@Override
	public Product update(int id, Product product) {
		Product exsitingproduct=getbyid(id);
		if(exsitingproduct != null) {
			exsitingproduct.setCost(product.getCost());
			exsitingproduct.setDesc(product.getDesc());
			exsitingproduct.setFoodtype(product.getFoodtype());
			exsitingproduct.setImagelink(product.getImagelink());
			exsitingproduct.setName(product.getName());
			exsitingproduct.setType(product.getType());
			return productrepository.save(exsitingproduct);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Product product=getbyid(id);
		if(product !=null) {
			productrepository.delete(product);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Product> getByType(String type) {
		// TODO Auto-generated method stub
		return productrepository.findByType(type);
		
	}

}
