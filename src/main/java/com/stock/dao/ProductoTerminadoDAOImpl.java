package com.stock.dao;

import java.util.List;

import javax.persistence.*;

import com.stock.model.ProductoTerminado;

public class ProductoTerminadoDAOImpl implements ProductoTerminadoDAO {

	private EntityManagerFactory emf;

    public ProductoTerminadoDAOImpl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
	@Override
	public void guardar(ProductoTerminado obj) {
		// TODO Auto-generated method stub
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
	public void actualizar(ProductoTerminado obj) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		try {
			transaction.begin();
		    // Se supone que esto busca en la base de datos?
			ProductoTerminado objMod = em.find(ProductoTerminado.class, obj.getCodigo());
		    // Se cambian los datos del elemento almacenado, aunque acá no se sabe cual
		    objMod.setCodigo(obj.getCodigo());
		    objMod.setProducto(obj.getProducto());
		    objMod.setUnidades(obj.getUnidades());
		    objMod.setComponentes(obj.getComponentes());
		    objMod.setUsuario(obj.getUsuario());
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
	public void eliminar(ProductoTerminado obj) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            // Se supone que esto busca en la base de datos?
            ProductoTerminado objElim = em.find(ProductoTerminado.class, obj.getCodigo());
            
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
	public ProductoTerminado obtenerPorId(int id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		ProductoTerminado obj = null;
		
		try {
		    // Buscar el elemento por su ID utilizando el método find del EntityManager
		    obj = em.find(ProductoTerminado.class, id); // idDelItem es el ID del elemento que deseas obtener

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
	public List<ProductoTerminado> obtenerTodos() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUP");
		EntityManager em = emf.createEntityManager();
		List<ProductoTerminado> objs = null;
		
		try {
		    // Crear una consulta JPQL para seleccionar todos los elementos de la tabla Item
		    Query query = em.createQuery("SELECT i FROM ProductoTerminado i");

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
	};
}


