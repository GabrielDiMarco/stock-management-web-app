package com.stock.dao;

import com.stock.model.Usuario;
import org.jvnet.hk2.annotations.Contract;

@Contract
public interface UsuarioDAO extends GenericDAO<Usuario>{

	Usuario obtenerPorNombre(String nombre);
	
	// No lo puedo poner acá si tiene static en Impl
	boolean validar(String user, String password);
}
