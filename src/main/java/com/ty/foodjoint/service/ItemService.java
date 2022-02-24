package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.Item;
import com.ty.foodjoint.util.ResponseStructure;


public interface ItemService {

	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item);

	public ResponseEntity<ResponseStructure<Item>> getItemById(int id);

	public ResponseEntity<ResponseStructure<List<Item>>> getAllItem();

	public ResponseEntity<ResponseStructure<Item>> updateItem(int id, Item item);

	public ResponseEntity<ResponseStructure<String>> deleteItem(int id);

	public ResponseEntity<ResponseStructure<Item>> saveAllItem(Item item);

}
