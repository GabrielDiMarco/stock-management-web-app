package com.stock.dao;

import com.stock.model.FamProd;

import org.jvnet.hk2.annotations.Service;

@Service
public class FamProdDAOImpl extends GenericDAOImpl<FamProd> implements FamProdDAO {

	public FamProdDAOImpl() {
		this.setClase(FamProd.class);
	}
}

