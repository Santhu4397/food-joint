package com.ty.foodjoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodjoint.dao.UserDao;
import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.exception.IDNotFoundEcxepiton;
import com.ty.foodjoint.service.UserService;
import com.ty.foodjoint.util.ResponseStructuer;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public ResponseEntity<ResponseStructuer<User>> save(User user) {
		ResponseStructuer<User> structuer = new ResponseStructuer<User>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.save(user));
		ResponseEntity<ResponseStructuer<User>> responseEntity = new ResponseEntity<ResponseStructuer<User>>(structuer,
				HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<List<User>>> getall() {
		ResponseStructuer<List<User>> structuer = new ResponseStructuer<List<User>>();
		structuer.setStatus(HttpStatus.OK.value());
		structuer.setMessage("successfull");
		structuer.setData(dao.getall());
		ResponseEntity<ResponseStructuer<List<User>>> responseEntity = new ResponseEntity<ResponseStructuer<List<User>>>(
				structuer, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<User>> update(int id, User user) {
		ResponseStructuer<User> structuer = new ResponseStructuer<User>();
		ResponseEntity<ResponseStructuer<User>> entity;
		User existing = dao.update(id, user);
		if (existing != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			entity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData(null);
			entity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.NOT_FOUND);
			throw new IDNotFoundEcxepiton("UserID " + id + "not found/exist ");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<User>> getbyid(int id) {
		ResponseStructuer<User> structuer = new ResponseStructuer<User>();
		ResponseEntity<ResponseStructuer<User>> responseEntity;
		User user = dao.getbyid(id);
		if (user != null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.getbyid(id));
			responseEntity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.OK);

		} else {
			structuer.setStatus(HttpStatus.NOT_FOUND.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData(null);
			responseEntity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.NOT_FOUND);
			throw new IDNotFoundEcxepiton("UserID " + id + "not found/exist ");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<String>> delete(int id) {
		ResponseStructuer<String> structuer = new ResponseStructuer<String>();
		ResponseEntity<ResponseStructuer<String>> entity;
		if (dao.delete(id)) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData("User deleted");
			entity = new ResponseEntity<ResponseStructuer<String>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("ID :" + id + " NOTFOUND");
			structuer.setData("User not deleted");
			entity = new ResponseEntity<ResponseStructuer<String>>(structuer, HttpStatus.NOT_FOUND);
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructuer<User>> validateUser(String email, String password) {
	
		ResponseStructuer<User> structuer = new ResponseStructuer<User>();
		ResponseEntity<ResponseStructuer<User>> entity;
		User  user=dao.validateUser(email,password);
		if (user!=null) {
			structuer.setStatus(HttpStatus.OK.value());
			structuer.setMessage("successfull");
			structuer.setData(dao.validateUser(email,password));
			entity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.OK);
		} else {
			structuer.setStatus(HttpStatus.BAD_REQUEST.value());
			structuer.setMessage("email :"+email + " password:"+ password + " !!!NOT-MATCHING!!!!!!");
			structuer.setData(dao.validateUser(email,password));
			entity = new ResponseEntity<ResponseStructuer<User>>(structuer, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
