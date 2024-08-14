package com.stock.resources;

// Cual de los dos?
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
/*import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;*/

import java.security.Key;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;

import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


//DEPRECATED
import io.jsonwebtoken.SignatureAlgorithm;

import com.stock.dao.UsuarioDAO;
import com.stock.dao.UsuarioDAOImpl;
import com.stock.model.Token;
import com.stock.model.Usuario;

@Path("/auth")
public class LoginServicio {
	
	@Inject
	private UsuarioDAO userdao;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response validar(Usuario usuario) {
		// El mensaje no incluye el atributo valid del usuario, por lo que siempre llegará como false y dará un Bad Request
		// && usuario.getValid()
		if(usuario != null && usuario.getUsuario() != null && usuario.getContraseña() != null) {
			boolean status = userdao.validar(usuario.getUsuario(), usuario.getContraseña());
			//SignatureAlgorithm signAlg = SignatureAlgorithm.HS256;
			if(status) {
				String KEY = "6oDdTfDAen17nIdeWgBGny0c8vxLsTNDMUFOM78FHhs";
				
				//	COMO DEFINO UNA KEY
				//Key key;
				long tiempo = System.currentTimeMillis();
				String jwt = Jwts.builder()
								.signWith(SignatureAlgorithm.HS256, KEY)
								//.signWith(KEY)
								.setSubject("Gabriel")
								.setIssuedAt(new Date(tiempo))
								.setExpiration(new Date(tiempo+900000))
								.claim("mail", "datosUsuario")
								.compact();
				//JsonObject json = Json.createObjectBuilder().add("JWT", jwt).build();
				return Response.status(Response.Status.CREATED).entity(new Token(jwt)).build();
			}
			return Response.status(Response.Status.UNAUTHORIZED).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}	
	}
}
