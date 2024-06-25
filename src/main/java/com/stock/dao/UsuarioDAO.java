package com.stock.dao;

import java.util.List;

import org.glassfish.jersey.spi.Contract;

import com.stock.model.Usuario;

@Contract
public interface UsuarioDAO {

    void guardar(Usuario obj);

    void actualizar(Usuario obj);

    void eliminar(Usuario obj);

    void eliminarPorId(long objId);
    
    Usuario obtenerPorId(long objId);
    
    Usuario obtenerPorNombre(String nombre);
    
    List<Usuario> obtenerTodos();
    
}
