package com.stock.dao;

import java.util.List;

public interface GenericDAO<T> {

    void guardar(T obj);

    void actualizar(T obj);

    void eliminar(T obj);

    void eliminarPorId(long objId);
    
    T obtenerPorId(long objId);
    
    T obtenerPorNombre(String nombre);
    
    List<T> obtenerTodos();
    
    //void setClazz(Class<T> clazzToSet);
}
