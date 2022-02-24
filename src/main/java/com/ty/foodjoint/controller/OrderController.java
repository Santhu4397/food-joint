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

import com.ty.foodjoint.dto.Orders;
import com.ty.foodjoint.service.OrderService;
import com.ty.foodjoint.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("order")
	@ApiOperation("To save the order")
	@ApiResponses({ @ApiResponse(code = 200, message = "Saved Order"),
			@ApiResponse(code = 404, message = " Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders order) {
		return orderService.saveOrder(order);
	}

	@GetMapping("order")
	@ApiOperation("TO get all the list of orders")
	@ApiResponses({ @ApiResponse(code = 200, message = "Get all orders"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrder() {
		return orderService.getAllOrder();
	}

	@GetMapping("order/{id}")
	@ApiOperation("To get order by specified id ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Get Order by ID"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}

	@PutMapping("order/{id}")
	@ApiOperation("TO update the order")
	@ApiResponses({ @ApiResponse(code = 200, message = "Update Order"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(@PathVariable int id, @RequestBody Orders order) {
		return orderService.updateOrder(id, order);
	}

	@DeleteMapping("order")
	@ApiOperation("TO delete the Order")
	@ApiResponses({ @ApiResponse(code = 200, message = "Delete Order"),
			@ApiResponse(code = 404, message = "Class not found"),
			@ApiResponse(code = 500, message = "Internal Server error") })
	public ResponseEntity<ResponseStructure<String>> deleteOrder(@RequestParam int id) {
		return orderService.deleteOrder(id);
	}
}