package com.stock.dao;

import java.util.List;
import com.stock.model.ProductoTerminado;

public interface ProductoTerminadoDAO {

	// Método para guardar un nuevo Usuario en la base de datos
    void guardar(ProductoTerminado prod);
    
    // Método para actualizar un Usuario existente en la base de datos
    void actualizar(ProductoTerminado prod);
    
    // Método para eliminar un Usuario de la base de datos
    void eliminar(ProductoTerminado prod);
    
    // Método para obtener un Usuario por su ID
    ProductoTerminado obtenerPorId(int id);
    
    // Método para obtener todos los Usuario de la base de datos
    List<ProductoTerminado> obtenerTodos();
}
