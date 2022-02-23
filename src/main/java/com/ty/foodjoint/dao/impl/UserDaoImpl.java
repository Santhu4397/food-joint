package com.ty.foodjoint.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodjoint.dao.UserDao;
import com.ty.foodjoint.dto.User;
import com.ty.foodjoint.repository.Userrepository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	Userrepository ur;

	public User save(User user) {

		return ur.save(user);
	}

	public List<User> getall() {
		return ur.findAll();
	}

	public User getbyid(int id) {
		Optional<User> user = ur.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	public User update(int id, User user) {
		User existinguser = getbyid(id);
		if (existinguser != null) {
			existinguser.setEmail(user.getEmail());
			existinguser.setName(user.getName());
			existinguser.setPassword(user.getPassword());
			existinguser.setPhone(user.getPhone());
			return ur.save(user);
		}
		return null;
	}

	public boolean delete(int id) {

		User user = getbyid(id);
		if (user != null) {
			ur.delete(user);
			return true;
		} else {
			return false;
		}
	}

	public User validateUser(String email, String password) {
		User user = ur.validateUser(email, password);
		return user;
	}
}
