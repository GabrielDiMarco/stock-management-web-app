package com.stock.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.*;

import org.jvnet.hk2.annotations.*;

import com.stock.model.Base;
import com.stock.model.Producto;
import com.stock.singleton.SingletonManFact;

import jakarta.inject.Inject;

@Service
public class GenericDAOImpl<T extends Base> implements GenericDAO<T> {
    
    //public abstract Class<T> getClase();
	private Class<T> clase;
	private Object type;
	
	public Class<T> getClase() {
		return clase;
	}
	
	public void setClase(Class <T> clase) {
		this.clase = clase;
	}
	
	public GenericDAOImpl() {
		Type superClass = getClass().getGenericSuperclass();
        this.type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
	}
    
	@Override
	public void guardar(T obj) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
    	
        try {
            transaction.begin();
            em.persist(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //em.close();
        }
	}

	@Override
	public void actualizar(T obj) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
		    // Se cambian los datos del elemento almacenado, aunque acá no se sabe cual
		    em.merge(obj);	    
		    transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		    e.printStackTrace();
		} finally {
			//em.close();
		}
	}

	@Override
	public void eliminar(T obj) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            // Se supone que esto busca en la base de datos?
            T objElim = em.find(this.getClase(), obj.getId());
            
            if (objElim != null) {
                // Eliminar el objeto de la base de datos
                em.remove(objElim);
            } else {
            	System.out.println("El objeto no existe en la base de datos.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //em.close();
        }
	}

	public void eliminarPorId(long objId) {
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            // Se supone que esto busca en la base de datos?
            //T objElim = em.find(T.class, obj.getCodigo());
            T objElim = this.obtenerPorId(objId);
            
            if (objElim != null) {
                // Eliminar el objeto de la base de datos
                em.remove(objElim);
            } else {
            	System.out.println("El objeto no existe en la base de datos.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //em.close();
        }
	}

	@Override
	public T obtenerPorId(long objId) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		T obj = null;
		
		try {
			Class<? extends GenericDAOImpl> claseAux = this.getClass();
			Class<? extends Base> claseAux2 = this.obtenerTodos().get(0).getClass();
			obj = em.find(this.getClase(), objId);
			
			if (obj == null) {
		        System.out.println("No se encontró ningún elemento con el ID " + objId);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		return obj;
	}
	
	// NO FUNCIONA SI NO HAY ATRIBUTO NOMBRE -------------------------------------------------------------------------------
	@Override
	public T obtenerPorNombre(String nombre) {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		T obj = null;
		
		try {
			//obj = em.find(this.clase, objId);
			TypedQuery<T> query = em.createQuery("SELECT i FROM Item i WHERE i.nombre = :nombre", this.clase);
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

	@Override
	public List<T> obtenerTodos() {
		// TODO Auto-generated method stub
		EntityManager em = SingletonManFact.getInstance();
		EntityTransaction transaction = em.getTransaction();
		List<T> objs = null;
		
		try {
		    // Crear una consulta JPQL para seleccionar todos los elementos de la tabla Item
			String[] nombre = this.type.toString().split("\\.");
			//Query query = em.createQuery("SELECT i FROM " + nombre[nombre.length - 1].toLowerCase() + " i");
			Query query = em.createQuery("SELECT i FROM " + nombre[nombre.length - 1] + " i");
		    // Ejecutar la consulta y obtener la lista de resultados
		    objs = query.getResultList();

		    // Iterar sobre la lista de resultados y hacer algo con cada elemento
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		
		return objs;
	}
}
