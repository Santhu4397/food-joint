package com.ty.foodjoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodjoint.dto.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
