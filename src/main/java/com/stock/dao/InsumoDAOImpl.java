package com.stock.dao;

import com.stock.model.Insumo;

import org.jvnet.hk2.annotations.Service;

@Service
public class InsumoDAOImpl extends GenericDAOImpl<Insumo> implements InsumoDAO {

	public InsumoDAOImpl() {
		this.setClase(Insumo.class);
	}
}
