package com.stock.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties
@Table(name="USUARIO")
public class Usuario extends Base {

	@Column(name = "DNI")
	private int dni;
	
	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "CONTRASEÑA")
	private String contraseña;
	
	@Column(name = "ADMIN")
	private boolean admin;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;
	
	@Column(name = "ICORPORACION")
	private Date incorp;
	
	@OneToMany(mappedBy = "usuario")
	//@JsonIgnoreProperties(ignoreUnknown = true)
	private List<ProductoTerminado> prodTermi;
	
	@OneToMany(mappedBy = "usuario")
	//@JsonIgnoreProperties(ignoreUnknown = true)
	private List<Receta> recetas;
		
	public Usuario(){}
	
	public Usuario(int dni, String mail, String usuario, String contraseña, String nombre, String apellido, boolean admin) {
		this.dni = dni;
		this.mail = mail;
		this.usuario = usuario;
		this.contraseña = contraseña;
		//this.contrasenia = contraseña;
		this.nombre = nombre;
		this.apellido = apellido;
		this.admin = admin;
		this.incorp = new Date();
		this.prodTermi = new ArrayList<>();
		this.recetas = new ArrayList<>();
		//this.valid = true;
	}
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	// La fecha de incorporación no tiene "set", no se puede modificar
	public Date getIncorp() {
		return incorp;
	}

	public List<ProductoTerminado> getProdTermi() {
		return prodTermi;
	}
	public void setProdTermi(List<ProductoTerminado> prodTermi) {
		this.prodTermi = prodTermi;
	}
	
	public List<Receta> getRecetas() {
		return recetas;
	}
	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}
}
