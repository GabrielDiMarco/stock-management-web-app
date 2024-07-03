package com.stock.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="MATERIA_PRIMA")
public class MateriaPrima extends Producto {
	
	@Column(name = "ALMACENAMIENTO")
	private String almacenam;
	
	public MateriaPrima() {}
	
	//public MateriaPrima(int codigo, String producto, int unidades, List<Item> items, String almacenamiento) {
	public MateriaPrima(String producto, int unidades, List<Item> items, String almacenamiento) {
		//super(codigo, producto, unidades, items);
		super(producto, unidades, items);
		this.almacenam = almacenamiento;
	}
	
	public String getAlmacenam() {
		return almacenam;
	}
	public void setAlmacenam(String almacenam) {
		this.almacenam = almacenam;
	}
}
