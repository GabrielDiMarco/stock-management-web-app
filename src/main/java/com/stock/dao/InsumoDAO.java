package com.stock.dao;

import java.util.List;
import com.stock.model.Insumo;

public interface InsumoDAO {

	// Método para guardar un nuevo Usuario en la base de datos
    void guardar(Insumo insumo);
    
    // Método para actualizar un Usuario existente en la base de datos
    void actualizar(Insumo insumo);
    
    // Método para eliminar un Usuario de la base de datos
    void eliminar(Insumo insumo);
    
    // Método para obtener un Usuario por su ID
    Insumo obtenerPorId(int id);
    
    // Método para obtener todos los Usuario de la base de datos
    List<Insumo> obtenerTodos();
}
