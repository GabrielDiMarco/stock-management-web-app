package com.stock.dao;

/*
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.stock.model.Insumo;
import com.stock.model.MateriaPrima;

public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {
	
	private EntityManagerFactory emf;

    public MateriaPrimaDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
	@Override
	public void guardar(MateriaPrima obj) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
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
            em.close();
        }
	}

	@Override
	public void actualizar(MateriaPrima obj) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
		    // Se supone que esto busca en la base de datos?
			MateriaPrima objMod = em.find(MateriaPrima.class, obj.getCodigo());
		    // Se cambian los datos del elemento almacenado, aunque acá no se sabe cual
		    objMod.setCodigo(obj.getCodigo());
		    objMod.setProducto(obj.getProducto());
		    objMod.setUnidades(obj.getUnidades());
		    objMod.setItems(obj.getItems());
		    objMod.setAlmacenam(obj.getAlmacenam());
		    transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
		    e.printStackTrace();
		} finally {
			em.close();
		}
	}

	@Override
	public void eliminar(MateriaPrima obj) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            // Se supone que esto busca en la base de datos?
            MateriaPrima objElim = em.find(MateriaPrima.class, obj.getCodigo());
            
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
            em.close();
        }
	}

	@Override
	public MateriaPrima obtenerPorId(int id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		MateriaPrima obj = null;
		
		try {
		    // Buscar el elemento por su ID utilizando el método find del EntityManager
		    obj = em.find(MateriaPrima.class, id); // idDelItem es el ID del elemento que deseas obtener

		    // Verificar si se encontró el elemento
		    if (obj == null) {
		        // Manejar la situación en la que el elemento no se encontró
		        System.out.println("No se encontró ningún elemento con el ID " + id);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    // Cerrar el EntityManager
		    em.close();
		}
		return obj;
	}

	@Override
	public List<MateriaPrima> obtenerTodos() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		List<MateriaPrima> objs = null;
		
		try {
		    // Crear una consulta JPQL para seleccionar todos los elementos de la tabla Item
		    Query query = em.createQuery("SELECT i FROM MateriaPrima i");

		    // Ejecutar la consulta y obtener la lista de resultados
		    objs = query.getResultList();

		    // Iterar sobre la lista de resultados y hacer algo con cada elemento
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    // Cerrar el EntityManager
		    em.close();
		}
		
		return objs;
	}

}
*/
