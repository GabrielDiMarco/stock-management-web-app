package com.stock.dao;

import java.util.List;
import javax.persistence.*;

import com.stock.model.Compra;
import com.stock.model.Insumo;
import com.stock.model.Item;

public class ItemDAOImpl extends GenericDAOImpl<Item> implements ItemDAO {

	public Class<Item> getClase() {
    	return Item.class;
    }
}
