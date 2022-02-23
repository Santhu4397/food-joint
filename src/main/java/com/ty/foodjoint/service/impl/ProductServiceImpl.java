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
import com.ty.foodjoint.util.ResponseStructuer;
@Service
public class ProductServiceImpl implements ProductService {
@Autowired
	ProductDao dao;
	@Override
	public ResponseEntity<ResponseStructuer<Product>> save(Product product) {
		
		ResponseStructuer<Product> structuer=new ResponseStructuer<Product>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.save(product));
		ResponseEntity<ResponseStructuer<Product>> responseEntity=new ResponseEntity<ResponseStructuer<Product>>(structuer,HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<Product>> getbyid(int id) {
		ResponseStructuer<Product> structuer=new ResponseStructuer<Product>();
		ResponseEntity<ResponseStructuer<Product>>  responseEntity;
		Product product=dao.getbyid(id);
		if(product !=null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			 responseEntity=new ResponseEntity<ResponseStructuer<Product>>(structuer,HttpStatus.OK);
			return responseEntity;
		}
		else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("ID :"+id+" NOTFOUND");
			structuer.setData(null);
			responseEntity=new ResponseEntity<ResponseStructuer<Product>>(structuer,HttpStatus.NOT_FOUND);
			throw new IDNotFoundEcxepiton("ProductID "+id+"not found/exist ");
		}
	}

	@Override
	public ResponseEntity<ResponseStructuer <List<Product>>> getall() {
		ResponseStructuer<List<Product>> structuer=new ResponseStructuer<List<Product>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getall());
		ResponseEntity<ResponseStructuer< List<Product>>> responseEntity=new ResponseEntity<ResponseStructuer<List<Product>>>(structuer,HttpStatus.OK);
		return responseEntity ;
	}

	@Override
	public ResponseEntity<ResponseStructuer<Product>> update(int id, Product product) {
		ResponseStructuer<Product> structuer=new ResponseStructuer<Product>();
		ResponseEntity<ResponseStructuer<Product>> entity;
		Product existing=dao.update(id,product);
		if(existing != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			entity=new ResponseEntity<ResponseStructuer<Product>>(structuer,HttpStatus.OK);
		}else {
			structuer.setStatus(HttpStatus.BAD_REQUEST.value());
			structuer.setMessage("ID :"+id+" NOTFOUND");
			structuer.setData(null);
			entity=new ResponseEntity<ResponseStructuer<Product>>(structuer,HttpStatus.BAD_REQUEST );
			throw new IDNotFoundEcxepiton("ProductID "+id+"not found/exist ");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<String>> delete(int id) {
		ResponseStructuer<String> structuer=new ResponseStructuer<String>();
		ResponseEntity<ResponseStructuer<String>> entity;
		if(dao.delete(id)) {
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData("User deleted");
		entity=new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.OK);
		}
		else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :"+id+" NOTFOUND");
			structuer.setData("User not deleted");
			entity=new ResponseEntity<ResponseStructuer<String>>(structuer,HttpStatus.NOT_FOUND);
		}
		return entity ;
	}

	@Override
	public ResponseEntity<ResponseStructuer<List<Product>>> getByType(String type) {
		ResponseStructuer<List<Product>> structuer=new ResponseStructuer<List<Product>>();
		ResponseEntity<ResponseStructuer<List<Product>>> entity;
		List<Product> list =dao.getByType(type);
		if(list !=null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getByType(type));
			entity=new ResponseEntity<ResponseStructuer<List<Product>>>(structuer,HttpStatus.OK);
		}else {
			structuer.setStatus(HttpStatus.BAD_REQUEST.value());
			structuer.setMessage("Type :"+type+" NOTFOUND");
			structuer.setData(null);
			entity=new ResponseEntity<ResponseStructuer<List<Product>>>(structuer,HttpStatus.BAD_REQUEST );
			throw new IDNotFoundEcxepiton("ProductType "+type+"not found/exist ");
		}
		return entity;
		
	}
	

}
