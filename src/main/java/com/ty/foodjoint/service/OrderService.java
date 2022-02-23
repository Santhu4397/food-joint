package com.ty.foodjoint.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.foodjoint.dto.Orders;
import com.ty.foodjoint.util.ResponseStructure;


public interface OrderService {

	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order);

	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrder();

	public ResponseEntity<ResponseStructure<Orders>> getOrderById(int id);

	public ResponseEntity<ResponseStructure<Orders>> updateOrder(int id, Orders order);

	public ResponseEntity<ResponseStructure<String>> deleteOrder(int id);
}