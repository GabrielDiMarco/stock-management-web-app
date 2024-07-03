package com.stock.model;

import javax.persistence.*;

@Entity
@Table(name="PRODUCTO_TERMINADO")
public class ProductoTerminado extends Base {

	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "PRODUCTO")
	private String producto;
	
	@Column(name = "UNIDADES")
	private int unidades;

	@Column(name = "COMPONENTES")
	private Item[] componentes;
	
	@ManyToOne()
	private Usuario usuario;
	
	public ProductoTerminado(){}
	
	public ProductoTerminado(int codigo, String producto, int unidades, Item[] componentes) {
		this.codigo = codigo;
		this.producto = producto;
		this.unidades = unidades;
		this.componentes = componentes;
	}
	
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
	
	public Item[] getComponentes() {
		return componentes;
	}
	public void setComponentes(Item[] componentes) {
		this.componentes = componentes;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
