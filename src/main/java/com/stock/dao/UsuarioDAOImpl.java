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
		    return null;
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		return obj;
	}
	
	@Override
	public Usuario obtenerPorUsuario(String user) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		Usuario obj = null;
		
		try {
			//obj = em.find(this.clase, objId);
			//TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE usuario.usuario = :user", Usuario.class);
			TypedQuery<Usuario> query = em.createQuery("FROM Usuario WHERE usuario.usuario = :user", Usuario.class);
			//TypedQuery<Usuario> query = em.createQuery("FROM Usuario WHERE usuario.usuario = :user", user);
			query.setParameter("user", user);
	        //List<T> obj = query.getResultList().get(0);
			obj = query.getSingleResult();
			
			if (obj == null) {
		        System.out.println("No se encontró ningún elemento con el nombre de usuario " + user);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		    return null;
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		return obj;
	}
	
	public boolean validar(String user, String password) {
		Usuario userAuth = obtenerPorUsuario(user);
		if(userAuth == null || userAuth.getValid() == false) {
			System.out.print("El usuario no existe\n");
			return false;
		}
		/*System.out.print("Nombre del usuario: " + userAuth.getNombre() + "\n");
		if (user.equals(userAuth.getUsuario()) && password.equals(userAuth.getContraseña())) {
			System.out.print("Login exitoso\n");
		} else {
			System.out.print("La contraseña no coincide\n");
		}*/
		return (user.equals(userAuth.getUsuario()) && password.equals(userAuth.getContraseña()));
	}
}
