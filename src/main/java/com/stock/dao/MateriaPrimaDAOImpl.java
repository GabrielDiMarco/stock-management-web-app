package com.stock.dao;

import com.stock.model.MateriaPrima;

import org.jvnet.hk2.annotations.Service;

@Service
public class MateriaPrimaDAOImpl extends GenericDAOImpl<MateriaPrima> implements MateriaPrimaDAO {
	
	public MateriaPrimaDAOImpl() {
		this.setClase(MateriaPrima.class);
	}
	
}
