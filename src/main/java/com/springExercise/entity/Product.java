package com.springExercise.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="product")
public class Product implements Serializable {
	@Id //這是一個主鍵
	@GeneratedValue(strategy = GenerationType.IDENTITY) //自增主鍵
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String location;
	
	@Column
	private String descript;
	@Column
	private Integer price;
	@Column
	private String unit;

	@Override
	public String toString() {
		return "Product [name=" + name + ", location=" + location + ", descript=" + descript + ", price=" + price
				+ ", unit=" + unit + "]";
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	
	
	
	
	
}
