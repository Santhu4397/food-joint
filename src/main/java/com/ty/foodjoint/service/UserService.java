package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.util.ResponseStructuer;

public interface UserService {
	public ResponseEntity<ResponseStructuer<User>> save(User user);
	public ResponseEntity<ResponseStructuer<List<User>>> getall();
	public ResponseEntity<ResponseStructuer<User>> update(int id,User user);
	public	ResponseEntity<ResponseStructuer<User>>  getbyid(int id);
	public ResponseEntity<ResponseStructuer<String>> delete(int id);
	public ResponseEntity<ResponseStructuer<User>>  validateUser(String email, String password);
}
