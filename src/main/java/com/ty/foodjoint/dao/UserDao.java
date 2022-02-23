package com.ty.foodjoint.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ty.foodjoint.dto.User;


public interface UserDao {
	
	public User save(User user);
	public List<User> getall();
	public User update(int id,User user);
	public User getbyid(int id);
	public boolean delete(int id);
	public User validateUser(String email, String password);

}
