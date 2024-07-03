package com.stock.dao;

import com.stock.model.Base;

import org.jvnet.hk2.annotations.Service;

@Service
public class BaseDAOImpl extends GenericDAOImpl<Base> implements BaseDAO{

	public BaseDAOImpl() {
		this.setClase(Base.class);
	}
}
