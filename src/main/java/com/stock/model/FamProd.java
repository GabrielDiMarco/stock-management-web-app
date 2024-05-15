package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="FAMILIA_PRODUCTORA")
public class FamProd {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="FAMILIA_PRODUCTORA_ID")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "UBICACION")
	private String ubicacion;

	public FamProd(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
}
