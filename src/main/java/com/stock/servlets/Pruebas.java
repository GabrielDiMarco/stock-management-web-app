package com.stock.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import com.stock.model.*;
import com.stock.singleton.SingletonManFact;
import com.stock.dao.*;
/**
 * Servlet implementation class Pruebas
 */
public class Pruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// Agrega elemento a la BD ----------------------------------------------------------------------------------------------------
		/*
		//GenericDAO<Insumo> insumoDAO = new GenericDAOImpl<Insumo>(Insumo.class);
		//GenericDAO<Insumo> insumoDAO = new GenericDAOImpl<Insumo>(Insumo.class);
		//Insumo insumo = new Insumo(1, "Frasco 500ml", 100, new ArrayList<Item>(), "Recipiente");
		//GenericDAO<Insumo> insumoDAO = new GenericDAOImpl<Insumo>(Insumo.class);		
		//Insumo insumo = new Insumo(1, "Frasco 500ml", 100, null, "Recipiente");
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl(Usuario.class);
		Usuario user = new Usuario(41000000, "algo@algo.com", "juanUser", "juanPass", "Juan", "Diaz", false);
		UsuarioDAO userDAO = new UsuarioDAOImpl(Usuario.class);
		userDAO.guardar(user);
		*/
		// ----------------------------------------------------------------------------------------------------------------------------
		
		// Eliminar elemento de la BD con ID 1 ----------------------------------------------------------------------------------------

//		insumo = insumoDAO.obtenerPorId((int) 1);
//		System.out.println(insumo.getProducto());
//		insumoDAO.eliminar(insumo);

		// ----------------------------------------------------------------------------------------------------------------------------
		
		// Se obtienen Objetos Producto de la lista obtenerTodos() ------------------------------------------------------------------------
		/*
		GenericDAO<Usuario> prodDAO = new GenericDAOImpl<Usuario>(Usuario.class);
		List<Usuario> productos = prodDAO.obtenerTodos();
		
		try {
			System.out.println(productos.get(0));
		} catch (Exception e) {
			System.out.println("No se pudo imprimir por el error: " + e);
		} finally {
		    // Cerrar el EntityManager
		    //em.close();
		}
		*/
		// ----------------------------------------------------------------------------------------------------------------------------
		
		// Obtener un objeto Producto a través de un objeto Item ----------------------------------------------------------------------
		/*
		GenericDAO<MateriaPrima> matPriDAO = new GenericDAOImpl<MateriaPrima>(MateriaPrima.class);		
		MateriaPrima matPri = new MateriaPrima("Manzana", 100, new ArrayList<Item>(), "Congelador");
		GenericDAO<Item> itemDAO = new GenericDAOImpl<Item>(Item.class);		
		Item item = new Item(null, 100, null, null, null);
		
		// Se obtiene la lista, se agrega item al final, y se setea de nuevo
		List<Item> prodListaItem = matPri.getItems();
		prodListaItem.add(item);
		matPri.setItems(prodListaItem);
		
		item.setProducto(matPri);
		
		matPriDAO.guardar(matPri);
		itemDAO.guardar(item);
		
		//Item itemBusca = itemDAO.obtenerPorNombre("Manzana");
		MateriaPrima matBusca = matPriDAO.obtenerPorId(item.getProducto().getId());
		System.out.println(matBusca.getProducto() + ", " + matBusca.getUnidades());
		*/
		// ----------------------------------------------------------------------------------------------------------------------------
		
		SingletonManFact.closeInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
