package com.ty.foodjoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.foodjoint.dao.OrdersDao;
import com.ty.foodjoint.dto.Orders;
import com.ty.foodjoint.dto.Product;
import com.ty.foodjoint.exception.IDNotFoundEcxepiton;
import com.ty.foodjoint.service.OrderService;
import com.ty.foodjoint.util.ResponseStructure;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrdersDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order) {
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(dao.saveOrder(order));
		ResponseEntity<ResponseStructure<Orders>> responseEntity = new ResponseEntity<ResponseStructure<Orders>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrder() {
		ResponseStructure<List<Orders>> structure = new ResponseStructure<List<Orders>>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("success");
		structure.setData(dao.getAllOrder());
		ResponseEntity<ResponseStructure<List<Orders>>> responseEntity = new ResponseEntity<ResponseStructure<List<Orders>>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> getOrderById(int id) {
		ResponseEntity<ResponseStructure<Orders>> entity;
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		Orders order = dao.getOrderById(id);
		if (order != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData(dao.getOrderById(id));
			entity = new ResponseEntity<ResponseStructure<Orders>>(structure, HttpStatus.OK);
		} else {

			throw new IDNotFoundEcxepiton("Order Id:" + id + " is not found ");
		}
		return entity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Orders>> updateOrder(int id, Orders order) {
		ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Order updated");
		structure.setData(dao.updateOrder(id, order));
		ResponseEntity<ResponseStructure<Orders>> responseEntity = new ResponseEntity<ResponseStructure<Orders>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteOrder(int id) {
		ResponseEntity<ResponseStructure<String>> entity;
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Orders order = dao.getOrderById(id);
		if (dao.deleteOrder(id)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("success");
			structure.setData("product deleted");
			entity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {

			throw new IDNotFoundEcxepiton("Order Id:" + id + " is not found ");
		}
		return entity;
	}
}
