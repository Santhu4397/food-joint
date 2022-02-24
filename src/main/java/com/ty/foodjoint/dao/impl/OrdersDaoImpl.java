package com.ty.foodjoint.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodjoint.dao.OrdersDao;
import com.ty.foodjoint.dto.Orders;
import com.ty.foodjoint.repository.OrderRepository;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Orders saveOrder(Orders order) {
		Orders orders = orderRepository.save(order);
		return orders;
	}

	@Override
	public List<Orders> getAllOrder() {
		return orderRepository.findAll();
	}

	@Override
	public Orders getOrderById(int id) {

		Optional<Orders> optional = orderRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	@Override
	public Orders updateOrder(int id, Orders order) {
		Orders existingOrder = orderRepository.getById(id);
		if (existingOrder != null) {
			existingOrder.setCustomer_name(order.getCustomer_name());
			existingOrder.setCustomer_phone(order.getCustomer_phone());
			existingOrder.setDateTime(order.getDateTime());
			existingOrder.setStatus(order.getStatus());
			existingOrder.setTotalCost(order.getTotalCost());
			return orderRepository.save(existingOrder);
		} else
			return null;

	}

	@Override
	public boolean deleteOrder(int id) {
		Orders order = getOrderById(id);
		if (order != null) {
			orderRepository.delete(order);
			return true;
		} else
			return false;
	}
}
