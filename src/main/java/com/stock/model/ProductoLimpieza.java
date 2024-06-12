package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTO_LIMPIEZA")
public class ProductoLimpieza  extends Base{
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="PRODUCTO_LIMPIEZA_ID")
//	private Long id;
	
//	@Column(name = "CODIGO")
//	private int codigo;
	
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "CANTIDAD")
	private int cantidad;
	
	@Column(name = "USADO")
	private int usado;
	
	@Column(name = "STOCK")
	private int stock;

	public ProductoLimpieza(int codigo, String producto, int cantidad, int usado, int stock) {
		//this.codigo = codigo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.usado = usado;
		this.stock = stock;
	}
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
	
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getUsado() {
		return usado;
	}
	public void setUsado(int usado) {
		this.usado = usado;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
