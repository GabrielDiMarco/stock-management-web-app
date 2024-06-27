package com.stock.resources;

import java.util.List;

import com.stock.dao.GenericDAOImpl;
import com.stock.dao.UsuarioDAO;
import com.stock.dao.UsuarioDAOImpl;
import com.stock.model.FamProd;
import com.stock.model.Usuario;

import jakarta.inject.Inject;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;



@Path("/usuarios")
public class UsuariosResource {
	
	//@Inject
	private UsuarioDAO objdao = new UsuarioDAOImpl(Usuario.class);
	//private GenericDAO<Usuario> objdao;
	//private GenericDAO<Usuario> objdao = new GenericDAOImpl<Usuario>(Usuario.class);
	
	//private GenericDAO udao = FactoryDAO.getUsuarioDAO();
	private String mensaje;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> obtenerTodos(){
		//return udao.list();
		List<Usuario> lista = objdao.obtenerTodos();
		System.out.println(lista.toString());
		return lista;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerPorId(@PathParam("id") Integer id) {
		//Usuario u = udao.read(id);
		Usuario obj = objdao.obtenerPorId(id);
		if (obj != null){
			return Response.ok().entity(obj).build();
		} else {
			mensaje="No se encontró el usuario";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(Usuario obj) {
		// El if coprueba si el id del usuario que se intenta crear está repetido
		if(objdao.obtenerPorId(obj.getId()) == null){
			objdao.guardar(obj);
			return Response.status(Response.Status.CREATED).build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}
	/*
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(@PathParam("id") Integer id, Usuario obj){
		Usuario aux = objdao.obtenerPorId(id);
		if (aux != null){
			objdao.actualizar(obj);;
			return Response.ok().entity(obj).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("[]").build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response borrar(@PathParam("id") Integer id) {
		Usuario aux = objdao.obtenerPorId(id);
		if (aux != null) {
			objdao.eliminar(aux);
			return Response.noContent().build();
		} else {
			mensaje = "No existe el usuario con ese id";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		}
	}*/
}
