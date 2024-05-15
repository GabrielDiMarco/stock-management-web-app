package com.stock.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="VENTA")
public class Venta {

	@Id
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "ITEMS")
	private Item[] items;
	
	@Column(name = "UNIDADES")
	private int[] unidades;
	
	@Column(name = "IMPORTE")
	private float importe;
	
	@Column(name = "FECHA")
	private Date fecha;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	public int[] getUnidades() {
		return unidades;
	}
	public void setUnidades(int[] unidades) {
		this.unidades = unidades;
	}
	
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
