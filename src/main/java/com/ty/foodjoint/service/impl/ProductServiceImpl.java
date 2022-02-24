package com.ty.foodjoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodjoint.dao.ProductDao;
import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.exception.IDNotFoundEcxepiton;
import com.ty.foodjoint.service.ProductService;
import com.ty.foodjoint.util.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Product>> save(Product product) {

		ResponseStructure<Product> structuer = new ResponseStructure<Product>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.save(product));
		ResponseEntity<ResponseStructure<Product>> responseEntity = new ResponseEntity<ResponseStructure<Product>>(
				structuer, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> getbyid(int id) {
		ResponseStructure<Product> structuer = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> responseEntity;
		Product product = dao.getbyid(id);
		if (product != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			responseEntity = new ResponseEntity<ResponseStructure<Product>>(structuer, HttpStatus.OK);
			return responseEntity;
		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructure<Product>>(structuer, HttpStatus.NOT_FOUND);
			throw new IDNotFoundEcxepiton("ProductID " + id + "not found/exist ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> getall() {
		ResponseStructure<List<Product>> structuer = new ResponseStructure<List<Product>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getall());
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				structuer, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> update(int id, Product product) {
		ResponseStructure<Product> structuer = new ResponseStructure<Product>();
		ResponseEntity<ResponseStructure<Product>> entity;
		Product existing = dao.update(id, product);
		if (existing != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			entity = new ResponseEntity<ResponseStructure<Product>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.BAD_REQUEST.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData(null);
			entity = new ResponseEntity<ResponseStructure<Product>>(structuer, HttpStatus.BAD_REQUEST);
			throw new IDNotFoundEcxepiton("ProductID " + id + "not found/exist ");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		ResponseStructure<String> structuer = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> entity;
		if (dao.delete(id)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("User deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData("User not deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> getByType(String type) {
		ResponseStructure<List<Product>> structuer = new ResponseStructure<List<Product>>();
		ResponseEntity<ResponseStructure<List<Product>>> entity;
		List<Product> list = dao.getByType(type);
		if (list != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getByType(type));
			entity = new ResponseEntity<ResponseStructure<List<Product>>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.BAD_REQUEST.value());
			structuer.setMessage("Type :" + type + " NOTFOUND");
			structuer.setData(null);
			entity = new ResponseEntity<ResponseStructure<List<Product>>>(structuer, HttpStatus.BAD_REQUEST);
			throw new IDNotFoundEcxepiton("ProductType " + type + "not found/exist ");
		}
		return entity;

	}

}
