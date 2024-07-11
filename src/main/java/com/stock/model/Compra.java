package com.stock.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="COMPRA")
public class Compra extends Base {

	@OneToMany(mappedBy = "compra")
	@JsonIgnore
	private List<Item> items;
	
	@Column(name = "IMPORTE")
	private float importe;
	
	@Column(name = "FECHA")
	private Date fecha;

	public Compra() {}
	
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
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
