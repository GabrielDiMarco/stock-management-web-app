package com.stock.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import com.stock.dao.UsuarioDAO;
import com.stock.dao.UsuarioDAOImpl;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(UsuarioDAOImpl.class).to(UsuarioDAO.class).in(RequestScoped.class);		
	}

}