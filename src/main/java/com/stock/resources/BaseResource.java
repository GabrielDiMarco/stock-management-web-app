package com.stock.resources;

import java.util.List;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import com.stock.model.Base;
import com.stock.dao.*;

@Path("/base")
public class BaseResource {
	
	private GenericDAO<Base> objdao = new GenericDAOImpl<Base>(Base.class);
	//private GenericDAO udao = FactoryDAO.getUsuarioDAO();
	private String mensaje;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Base> obtenerTodos(){
		//return udao.list();
		return objdao.obtenerTodos();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerPorId(@PathParam("id") Integer id) {
		//Usuario u = udao.read(id);
		Base obj = objdao.obtenerPorId(id);
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
	public Response guardar(Base obj) {
		// El if coprueba si el id del usuario que se intenta crear está repetido
		if(objdao.obtenerPorId(obj.getId()) == null){
			objdao.guardar(obj);
			return Response.status(Response.Status.CREATED).build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(@PathParam("id") Integer id, Base obj){
		Base aux = objdao.obtenerPorId(id);
		if (aux != null){
			objdao.actualizar(obj);
			return Response.ok().entity(obj).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("[]").build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response borrar(@PathParam("id") Integer id) {
		Base aux = objdao.obtenerPorId(id);
		if (aux != null) {
			objdao.eliminar(aux);
			return Response.noContent().build();
		} else {
			mensaje = "No existe el usuario con ese id";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		}
	}
}
