package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="MATERIA_PRIMA")
public class MateriaPrima extends Producto {
	
	@Column(name = "ALMACENAMIENTO")
	private String almacenam;
	
	/*
	public MateriaPrima(int codigo, String tipo, int unidades, String almacenamiento, FamProd[] famProd) {
		this.codigo = codigo;
		this.tipo = tipo;
		this.unidades = unidades;
		this.almacenam = almacenamiento;
		this.famProd = famProd;
	}
	*/
	
	public String getAlmacenam() {
		return almacenam;
	}
	public void setAlmacenam(String almacenam) {
		this.almacenam = almacenam;
	}
}
