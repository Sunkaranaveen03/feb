package com.example.springboothibernet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private int id;
	@NotBlank
	@Length(min = 3 , max = 10 )
	private String name;
	private String color;
	@NotNull
	@Min(500)
	@Max(5000)
	private double price;
	@Pattern(regexp = "^[A-Z]{5}[1-9]{4}[A-Z]$")
	private String pan;
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", color=" + color + ", price=" + price ;
	}
	
	

}
