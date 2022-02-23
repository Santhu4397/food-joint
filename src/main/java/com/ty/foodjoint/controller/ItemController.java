package com.ty.foodjoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.foodjoint.dto.Item;
import com.ty.foodjoint.service.ItemService;
import com.ty.foodjoint.util.ResponseStructure;
import com.ty.foodjoint.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {

//	@Autowired
//	ItemDao dao;

	@Autowired
	ItemService service;

	@PostMapping("order/item")
	@ApiOperation("To save the item")
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Item"),
			@ApiResponse(code = 404, message = " Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Item>> saveItem(@ApiParam("Save the item") @RequestBody Item item) {
		return service.saveItem(item);
	}

	@PutMapping("order/item/{id}")
	@ApiOperation("TO update the item")
	@ApiResponses({ @ApiResponse(code = 200, message = "Update Item"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Item>> updateUser(@PathVariable int id, @RequestBody Item item) {
		return service.updateItem(id, item);
	}

	@DeleteMapping("order/item")
	@ApiOperation("TO delete the Item")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete Item"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteItem(@RequestParam int id) {
		return service.deleteItem(id);
	}

	@GetMapping("order/item/{id}")
	@ApiOperation("To get item by specified id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Get Item by ID"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Item>> getItemById(@PathVariable int id) {
		return service.getItemById(id);
	}

	@GetMapping("order/item")
	@ApiOperation("TO get all the list of item")
	@ApiResponses({ @ApiResponse(code = 200, message = "Get all item"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Item>>> getAllItem() {
		return service.getAllItem();
	}

}
