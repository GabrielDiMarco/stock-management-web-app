package com.stock.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRODUCTO")
public abstract class Producto extends Base{

	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "UNIDADES")
	private int unidades;
	
	@OneToMany(mappedBy = "producto")
	@JsonIgnore
	private List<Item> items;

	public Producto() {}
	
	public Producto(String producto, int unidades, List<Item> items) {	
		//this.codigo = codigo;
		this.producto = producto;
		this.unidades = unidades;
		this.items = items;
	}
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
