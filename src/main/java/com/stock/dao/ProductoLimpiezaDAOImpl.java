package com.stock.dao;

import com.stock.model.ProductoLimpieza;
import org.jvnet.hk2.annotations.Service;

@Service
public class ProductoLimpiezaDAOImpl extends GenericDAOImpl<ProductoLimpieza> implements ProductoLimpiezaDAO {

	
	public ProductoLimpiezaDAOImpl() {
		this.setClase(ProductoLimpieza.class);
	}
}
