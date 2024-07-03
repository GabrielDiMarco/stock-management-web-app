package com.stock.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="FAMILIA_PRODUCTORA")
public class FamProd extends Base {

//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	@Column(name="FAMILIA_PRODUCTORA_ID")
//	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "UBICACION")
	private String ubicacion;
	
	@OneToMany(mappedBy = "famProd")
	private List<Item> items;

	public FamProd(){}
	
	public FamProd(String nombre, String ubicacion) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
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
	
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
