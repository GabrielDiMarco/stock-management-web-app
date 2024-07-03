package com.stock.dao;

import com.stock.model.ProductoTerminado;
import org.jvnet.hk2.annotations.Service;

@Service
public class ProductoTerminadoDAOImpl extends GenericDAOImpl<ProductoTerminado> implements ProductoTerminadoDAO {

	
	public ProductoTerminadoDAOImpl() {
		this.setClase(ProductoTerminado.class);
	}
}


