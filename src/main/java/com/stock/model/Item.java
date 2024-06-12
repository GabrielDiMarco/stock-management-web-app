package com.stock.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ITEM")
public class Item extends Base {
	
//	@Column(name = "CODIGO")
//	private int codigo;
	
	@ManyToOne()
	private Producto producto;
	
	@Column(name = "UNIDADES")
	private int unidades;
	
	@ManyToOne()
	private FamProd famProd;
	
	@ManyToOne()
	private Compra compra;
	
	@ManyToOne()
	private Venta venta;
	
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
	
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
