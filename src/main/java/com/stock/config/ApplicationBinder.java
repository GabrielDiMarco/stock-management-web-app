package com.stock.config;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import com.stock.dao.*;

public class ApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(UsuarioDAOImpl.class).to(UsuarioDAO.class).in(RequestScoped.class);
		bind(CompraDAOImpl.class).to(CompraDAO.class).in(RequestScoped.class);
		bind(FamProdDAOImpl.class).to(FamProdDAO.class).in(RequestScoped.class);
		bind(InsumoDAOImpl.class).to(InsumoDAO.class).in(RequestScoped.class);
		bind(ItemDAOImpl.class).to(ItemDAO.class).in(RequestScoped.class);
		bind(MateriaPrimaDAOImpl.class).to(MateriaPrimaDAO.class).in(RequestScoped.class);
		bind(ProductoDAOImpl.class).to(ProductoDAO.class).in(RequestScoped.class);
		bind(ProductoLimpiezaDAOImpl.class).to(ProductoLimpiezaDAO.class).in(RequestScoped.class);
		bind(ProductoTerminadoDAOImpl.class).to(ProductoTerminadoDAO.class).in(RequestScoped.class);
		bind(RecetaDAOImpl.class).to(RecetaDAO.class).in(RequestScoped.class);
		bind(VentaDAOImpl.class).to(VentaDAO.class).in(RequestScoped.class);
	}
}