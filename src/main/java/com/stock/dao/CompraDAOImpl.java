package com.stock.dao;

import com.stock.model.Compra;

import org.jvnet.hk2.annotations.Service;

@Service
public class CompraDAOImpl extends GenericDAOImpl<Compra> implements CompraDAO {

	public CompraDAOImpl() {
		this.setClase(Compra.class);
	}
}
