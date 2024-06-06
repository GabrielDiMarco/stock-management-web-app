package com.stock.dao;

import java.util.List;

import com.stock.model.MateriaPrima;

public interface MateriaPrimaDAO {
	// Método para guardar un nuevo Usuario en la base de datos
    void guardar(MateriaPrima obj);
    
    // Método para actualizar un Usuario existente en la base de datos
    void actualizar(MateriaPrima obj);
    
    // Método para eliminar un Usuario de la base de datos
    void eliminar(MateriaPrima obj);
    
    // Método para obtener un Usuario por su ID
    MateriaPrima obtenerPorId(int id);
    
    // Método para obtener todos los Usuario de la base de datos
    List<MateriaPrima> obtenerTodos();
}
