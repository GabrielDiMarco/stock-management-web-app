package com.stock.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="INSUMO")
public class Insumo extends Producto {

	@Column(name = "TIPO")
	private String tipo;
	
	public Insumo() {}
	
	public Insumo(String producto, int unidades, List<Item> items, String tipo) {
		
		super(producto, unidades, items);
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
