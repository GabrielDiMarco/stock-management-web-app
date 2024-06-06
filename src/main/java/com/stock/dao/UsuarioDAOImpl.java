package com.stock.dao;

import javax.persistence.*;

import com.stock.model.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {
    
    public UsuarioDAOImpl(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

	public Class<Usuario> getClase() {
    	return Usuario.class;
    }
}
