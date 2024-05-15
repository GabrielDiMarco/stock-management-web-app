package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="VENTA")
public class Item {
	
	@Id
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "PRODUCTO")
	private Producto producto;
	
	@Column(name = "UNIDADES")
	private int unidades;
	
	@Column(name = "FAMILIA_PRODUCTORA")
	private FamProd famProd;
	
	@Column(name = "COMPRA")
	private Compra compra;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	
	public FamProd getFamProd() {
		return famProd;
	}
	public void setFamProd(FamProd famProd) {
		this.famProd = famProd;
	}
	
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
}
