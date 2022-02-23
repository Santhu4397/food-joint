package com.ty.foodjoint.dao;

import java.util.List;

import com.ty.foodjoint.dto.Orders;

public interface OrdersDao {

	public Orders saveOrder(Orders order);

	public List<Orders> getAllOrder();

	public Orders getOrderById(int id);

	public Orders updateOrder(int id, Orders order);

	public boolean deleteOrder(int id);
}
