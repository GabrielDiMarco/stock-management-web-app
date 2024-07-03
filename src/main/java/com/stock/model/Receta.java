package com.stock.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="RECETA")
public class Receta  extends Base{

//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	@Column(name="RECETA_ID")
//	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "INGREDIENTES")
	private String[] ingredientes;
	
	@Column(name = "INSTRUCCIONES")
	private String instrucciones;

	@ManyToOne()
	@JsonIgnore
	private Usuario usuario;
	
	public Receta(){}
	
	public Receta(String nombre, String[] ingredientes, String instrucciones) {
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.instrucciones = instrucciones;
	}
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String[] getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String[] ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public String getInstrucciones() {
		return instrucciones;
	}
	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
