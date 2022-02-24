package com.ty.foodjoint.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.foodjoint.dao.ItemDao;
import com.ty.foodjoint.dto.Item;
import com.ty.foodjoint.repository.ItemRepository;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemRepository repository;

	@Override
	public Item saveItem(Item item) {
		return repository.save(item);
	}

	@Override
	public Item getItemById(int id) {
		Optional<Item> items = repository.findById(id);
		if (items != null) {
			return items.get();
		} else
			return null;
	}

	@Override
	public List<Item> getAllItem() {
		return repository.findAll();
	}

	@Override
	public Item updateItem(int id, Item item) {
		Item existingItem = getItemById(id);
		if (existingItem != null) {
			existingItem.setCost(item.getCost());
			existingItem.setName(item.getName());
			existingItem.setQuantity(item.getQuantity());
			return repository.save(existingItem);
		}
		return null;
	}

	@Override
	public boolean deleteItem(int id) {
		Item item = getItemById(id);
		if (item != null) {
			repository.delete(item);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Item saveAllItem(Item item) {
		return repository.save(item);
	}

}
