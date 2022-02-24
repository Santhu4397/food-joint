package com.ty.foodjoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ty.foodjoint.dao.ItemDao;
import com.ty.foodjoint.dto.Item;
import com.ty.foodjoint.exception.IDNotFoundEcxepiton;

import com.ty.foodjoint.service.ItemService;
import com.ty.foodjoint.util.ResponseStructure;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Item>> saveItem(Item item) {
		ResponseStructure<Item> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.saveItem(item));
		ResponseEntity<ResponseStructure<Item>> responseEntity = new ResponseEntity<ResponseStructure<Item>>(structure,
				HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Item>> getItemById(int id) {
		ResponseStructure<Item> structure = new ResponseStructure<Item>();
		ResponseEntity<ResponseStructure<Item>> responseEntity = null;
		Item item = dao.getItemById(id);
		if (item != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.getItemById(id));
			responseEntity = new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.OK);
		} else {
			throw new IDNotFoundEcxepiton("Item Id " + id + "not found");
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Item>>> getAllItem() {
		ResponseStructure<List<Item>> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<List<Item>>> responseEntity = null;
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.getAllItem());
		responseEntity = new ResponseEntity<ResponseStructure<List<Item>>>(structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Item>> updateItem(int id, Item item) {
		ResponseStructure<Item> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Item>> responseEntity = null;
		Item item1 = dao.getItemById(id);
		if (item1 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.saveItem(item));
			responseEntity = new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData(dao.saveItem(item));
			responseEntity = new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.OK);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteItem(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = null;
		if (dao.deleteItem(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Sucess");
			structure.setData("Item deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setMessage("data not fond");
			structure.setData("Item not  deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Item>> saveAllItem(Item item) {
		ResponseStructure<Item> structure = new ResponseStructure<>();
		ResponseEntity<ResponseStructure<Item>> responseEntity = null;
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Sucess");
		structure.setData(dao.saveAllItem(item));
		responseEntity = new ResponseEntity<ResponseStructure<Item>>(structure, HttpStatus.OK);
		return responseEntity;
	}

}
