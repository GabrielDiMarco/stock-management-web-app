package com.stock.resources;

import java.util.List;

import com.stock.dao.*;
import com.stock.model.*;

import jakarta.inject.Inject;
//import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


@Path("/usuario")
public class UsuariosResource {
	
	@Inject
	private UsuarioDAO objdao;
	
	private String mensaje;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> obtenerTodos(){

		List<Usuario> lista = objdao.obtenerTodos();
		System.out.println(lista.toString());
		return lista;
	}
	
	@GET
	@Path("{id}")
	//@Path("user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerPorId(@PathParam("id") Long id) {
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
		try {
			objdao.guardar(obj);
			return Response.ok().build();
			//return Response.status(Response.Status.CREATED).build();
		} catch (Exception e) {
		    e.printStackTrace();
		    return Response.serverError().build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(Usuario obj){
		Usuario aux = objdao.obtenerPorId(obj.getId());
		if (aux != null){
			objdao.actualizar(obj);
			return Response.ok().entity(obj).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("[]").build();
		}
	}
	
	// NO ELIMINAR, USAR BORRADO LOGICO (VARIABLE QUE ANULA LA VALIDEZ DEL ELEMENTO)
	@Path("{id}")
	@DELETE
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
	}
}
