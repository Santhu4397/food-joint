package com.ty.foodjoint.dao;

import java.util.List;

import com.ty.foodjoint.dto.Item;

public interface ItemDao {

	public Item saveItem(Item item);

	public Item getItemById(int id);

	public List<Item> getAllItem();

	public Item updateItem(int id, Item item);

	public boolean deleteItem(int id);

	public Item saveAllItem(Item item);
}
