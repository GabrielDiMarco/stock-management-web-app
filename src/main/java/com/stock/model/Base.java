package com.stock.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Base {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "ID")
	Long id;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public Base(){}
}
