package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.util.ResponseStructure;

public interface UserService {
	public ResponseEntity<ResponseStructure<User>> save(User user);

	public ResponseEntity<ResponseStructure<List<User>>> getall();

	public ResponseEntity<ResponseStructure<User>> update(int id, User user);

	public ResponseEntity<ResponseStructure<User>> getbyid(int id);

	public ResponseEntity<ResponseStructure<String>> delete(int id);

	public ResponseEntity<ResponseStructure<User>> validateUser(String email, String password);
}
