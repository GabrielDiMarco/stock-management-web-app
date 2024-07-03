package com.stock.resources;

import java.util.List;

import com.stock.dao.*;
import com.stock.model.*;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/materia-prima")
public class MateriaPrimaResource {

	@Inject
	private MateriaPrimaDAO objdao;
	
	private String mensaje;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MateriaPrima> obtenerTodos(){
		
		List<MateriaPrima> lista = objdao.obtenerTodos();
		System.out.println(lista.toString());
		return lista;
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerPorId(@PathParam("id") Integer id) {
		//Usuario u = udao.read(id);
		MateriaPrima obj = objdao.obtenerPorId(id);
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
	public Response guardar(MateriaPrima obj) {
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
	public Response editar(MateriaPrima obj){
		MateriaPrima aux = objdao.obtenerPorId(obj.getId());
		if (aux != null){
			objdao.actualizar(obj);
			return Response.ok().entity(obj).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("[]").build();
		}
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response borrar(@PathParam("id") Integer id) {
		MateriaPrima aux = objdao.obtenerPorId(id);
		if (aux != null) {
			objdao.eliminar(aux);
			return Response.noContent().build();
		} else {
			mensaje = "No existe el usuario con ese id";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		}
	}
}
