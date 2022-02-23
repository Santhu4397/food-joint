package com.ty.foodjoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.foodjoint.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
