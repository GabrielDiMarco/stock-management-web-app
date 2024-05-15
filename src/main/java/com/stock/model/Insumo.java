package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="INSUMO")
public class Insumo extends Producto {

	@Column(name = "TIPO")
	private String tipo;
	
	/*
	public Insumo(int codigo, String producto, int cantidad, int unidades, FamProd[] famProd) {
		this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.unidades = unidades;
		this.famProd = famProd;
	}
	*/
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
