package com.stock.model;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@MappedSuperclass
public abstract class Base {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "ID")
	Long id;
	
	@Column(name = "VALID")
	@ColumnDefault("1")
	boolean valid;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public Base(){}
}
