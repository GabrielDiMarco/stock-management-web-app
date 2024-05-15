package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTO")
public abstract class Producto {
	
	@Id
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "UNIDADES")
	private int unidades;
	
	@Column(name = "ITEMS")
	private Item[] items;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
}
