package com.stock.dao;

import com.stock.model.Producto;
import org.jvnet.hk2.annotations.Service;

@Service
public class ProductoDAOImpl extends GenericDAOImpl<Producto> implements ProductoDAO {

	public ProductoDAOImpl() {
		this.setClase(Producto.class);
	}
}
