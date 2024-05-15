package com.stock.dao;

import java.util.List;
import com.stock.model.Usuario;

public interface UsuarioDAO {
	
	// Método para guardar un nuevo Usuario en la base de datos
    void guardar(Usuario user);
    
    // Método para actualizar un Usuario existente en la base de datos
    void actualizar(Usuario user);
    
    // Método para eliminar un Usuario de la base de datos
    void eliminar(Usuario user);
    
    // Método para obtener un Usuario por su ID
    Usuario obtenerPorId(int id);
    
    // Método para obtener todos los Usuario de la base de datos
    List<Usuario> obtenerTodos();
}
