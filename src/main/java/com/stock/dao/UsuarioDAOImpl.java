package com.stock.dao;

import javax.persistence.*;

import com.stock.model.Usuario;
import org.jvnet.hk2.annotations.Service;
import com.stock.singleton.SingletonManFact;

@Service
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {
	
	public UsuarioDAOImpl() {
		this.setClase(Usuario.class);
	}
	
	@Override
	public Usuario obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		Usuario obj = null;
		
		try {
			//obj = em.find(this.clase, objId);
			TypedQuery<Usuario> query = em.createQuery("SELECT i FROM Item i WHERE i.nombre = :nombre", Usuario.class);
			query.setParameter("nombre", nombre);
	        //List<T> obj = query.getResultList().get(0);
			obj = query.getSingleResult();
			
			if (obj == null) {
		        System.out.println("No se encontró ningún elemento con el nombre " + nombre);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		return obj;
	}
}
