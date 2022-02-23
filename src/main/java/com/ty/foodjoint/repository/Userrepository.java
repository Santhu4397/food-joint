package com.ty.foodjoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.foodjoint.dto.User;

public interface Userrepository extends JpaRepository<User, Integer> {

	@Query("Select u from User u WHERE u.email =?1 AND u.password =?2")
	public User validateUser(String email,String password);
}
