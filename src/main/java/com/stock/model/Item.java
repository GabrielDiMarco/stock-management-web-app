package com.stock.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ITEM")
public class Item extends Base {
	
	@ManyToOne()
	@JsonIgnore
	private Producto producto;
	
	@Column(name = "UNIDADES")
	private int unidades;
	
	@ManyToOne()
	@JsonIgnore
	private FamProd famProd;
	
	@ManyToOne()
	@JsonIgnore
	private Compra compra;
	
	@ManyToOne()
	@JsonIgnore
	private Venta venta;

	public Item(){}
	
	public Item(Producto producto, int unidades, FamProd famProd, Compra compra, Venta venta) {	
		this.producto = producto;
		this.unidades = unidades;
		this.famProd = famProd;
		this.compra = compra;
		this.venta = venta;
	}
	
	public Item(MateriaPrima producto, int unidades, FamProd famProd, Compra compra, Venta venta) {	
		this.producto = producto;
		this.unidades = unidades;
		this.famProd = famProd;
		this.compra = compra;
		this.venta = venta;
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
	
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
}
