package com.stock.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="VENTA")
public class Venta  extends Base{

	@OneToMany(mappedBy = "venta")
	@JsonIgnore
	private List<Item> items;
	
	@Column(name = "UNIDADES")
	private int[] unidades;
	
	@Column(name = "IMPORTE")
	private float importe;
	
	@Column(name = "FECHA")
	private Date fecha;

	public Venta(){}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
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
