package com.stock.dao;

import com.stock.model.Item;

import org.jvnet.hk2.annotations.Service;

@Service
public class ItemDAOImpl extends GenericDAOImpl<Item> implements ItemDAO {

	public ItemDAOImpl() {
		this.setClase(Item.class);
	}
}
